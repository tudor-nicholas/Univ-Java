package OOP.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;
import java.util.Scanner;

public class TeacherManagementApp extends Frame implements ItemListener {
    private static final String TEACHERS_FILE_PATH = "D:\\Vs Code\\JavaJet\\src\\OOP\\Project\\teachers.txt";
    private List list;
    private Checkbox chkHigh, chkCollage;
    private CheckboxGroup cg;
    private Label lblTeacherName, lblTeacherExp, lblTeacherGrade, lblTeacherHours, lblTeacherTitle, lblTeacherYears,
            modLblTeacherName, modLblTeacherExp, modLblTeacherTitle, modLblTeacherYears, modLblTeacherGrade,
            modLblTeacherHours, delLblTeacherName, errorText;
    private TextField txtTeacherName, txtTeacherExp, txtTeacherGrade, txtTeacherHours, txtTeacherTitle, txtTeacherYears,
            modTxtTeacherName, modTxtTeacherExp, modTxtTeacherTitle, modTxtTeacherYears, modTxtTeacherGrade,
            modTxtTeacherHours, delTxtTeacherName;
    private Button btnSaveAdd, btnCancelAdd, btnSaveMod, btnCancelMod, btnExit, delBtn, addbtn, modbtn, delbtn;
    private Panel mainPanel, checkboxPanel, addPanel, highPanel, modPanel, specificModPanel, delPanel;
    private ArrayList<Teacher> teachersList;
    private Teacher selectedTeacherUniversal;
    public TeacherManagementApp(String title) {
        super(title);
        setLayout(new FlowLayout());

        list = new List();
        list.setFont(new Font("Arial", Font.PLAIN, 12));

        teachersList = readTeachersFromFile();
        for (Teacher teacher : teachersList) {
            list.add(teacher.toString());
        }

        add(list);

        list.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    Teacher selectedTeacher = teachersList.get(selectedIndex);
                    System.out.println("Selected teacher: " + selectedTeacher);
                    selectedTeacherUniversal = selectedTeacher;
                    if (modLblTeacherName != null) {
                        buttonControl("mod");
                    }
                    if (delLblTeacherName != null) {
                        buttonControl("del");
                    }
                }
            }
        });

        mainPanel = new Panel();
        addbtn = new Button("Add Teachers");
        addbtn.addActionListener(e -> buttonControl("add"));
        modbtn = new Button("Modify Teachers");
        modbtn.addActionListener(e -> buttonControl("mod"));
        delbtn = new Button("Delete Teachers");
        delbtn.addActionListener(e -> buttonControl("del"));
        btnExit = new Button("Exit");
        btnExit.addActionListener(e -> saveToFile());
        mainPanel.add(addbtn);
        mainPanel.add(modbtn);
        mainPanel.add(delbtn);
        mainPanel.add(btnExit);
        add(mainPanel);

        setSize(720, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ArrayList<Teacher> readTeachersFromFile() {
        ArrayList<Teacher> teacherList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(TEACHERS_FILE_PATH))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] part = line.split("  ");
                switch (part[0]) {
                    case "high":
                        teacherList.add(new HighSchoolTeacher(part[1], Integer.parseInt(part[2]), part[3], Integer.parseInt(part[4])));
                        break;
                    case "college":
                        teacherList.add(new CollegeTeacher(part[1], Integer.parseInt(part[2]), part[3], Integer.parseInt(part[4])));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return teacherList;
    }
    public void buttonControl(String type) {
        if (Objects.equals(type, "add")) {
            if (modPanel != null) {
                remove(modPanel);
                remove(specificModPanel);
            }
            if (delPanel != null) {
                remove(delPanel);
            }
            initializeAddPanel();
            add(addPanel);
            validate();
        } else if (Objects.equals(type, "mod")) {
            if (addPanel != null) {
                remove(addPanel);
                remove(checkboxPanel);
                remove(highPanel);
            }
            if (delPanel != null) {
                remove(delPanel);
            }
            if (modPanel != null) {
                remove(modPanel);
            }
            initializeModPanel();
            validate();
        } else if (Objects.equals(type, "del")) {
            if (addPanel != null) {
                remove(addPanel);
                remove(checkboxPanel);
                remove(highPanel);
            }
            if (modPanel != null) {
                remove(modPanel);
                remove(specificModPanel);
            }
            initializeDelPanel();
            add(delPanel);
            validate();
        }
    }
    private void initializeAddPanel() {
        cg = new CheckboxGroup();
        chkHigh = new Checkbox("Highschool Teacher", true, cg);
        chkCollage = new Checkbox("Collage Teacher", false, cg);

        checkboxPanel = new Panel();
        checkboxPanel.add(chkHigh);
        checkboxPanel.add(chkCollage);

        chkHigh.addItemListener(this);
        chkCollage.addItemListener(this);

        add(checkboxPanel);

        addPanel = new Panel();
        lblTeacherName = new Label("Teacher Name:");
        txtTeacherName = new TextField(20);
        lblTeacherExp = new Label("Teacher Experience:");
        txtTeacherExp = new TextField(20);

        addPanel.add(lblTeacherName);
        addPanel.add(txtTeacherName);
        addPanel.add(lblTeacherExp);
        addPanel.add(txtTeacherExp);
    }
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == chkHigh && chkHigh.getState()) {
            if (highPanel == null) {
                highPanel = new Panel();
            } else {
                highPanel.removeAll();
            }

            lblTeacherGrade = new Label("Teacher Grade:");
            txtTeacherGrade = new TextField(20);
            lblTeacherHours = new Label("Teacher Hours:");
            txtTeacherHours = new TextField(20);
            btnSaveAdd = new Button("Save");
            btnCancelAdd = new Button("Cancel");

            highPanel.add(lblTeacherGrade);
            highPanel.add(txtTeacherGrade);
            highPanel.add(lblTeacherHours);
            highPanel.add(txtTeacherHours);

            highPanel.add(btnSaveAdd);
            highPanel.add(btnCancelAdd);

            add(highPanel);

            btnSaveAdd.addActionListener(event -> {
                try {
                    if (Integer.parseInt(txtTeacherExp.getText()) < 60 && Integer.parseInt(txtTeacherHours.getText()) < 40
                            && !searchForTeacher(txtTeacherName.getText())) {
                        teachersList.add(new HighSchoolTeacher(txtTeacherName.getText(), Integer.parseInt(txtTeacherExp.getText()),
                                txtTeacherGrade.getText(), Integer.parseInt(txtTeacherHours.getText())));
                        updateList();
                        addPanel.removeAll();highPanel.removeAll();checkboxPanel.removeAll();
                        if (errorText != null) {remove(errorText);}setSize(720, 251); setSize(720, 250);
                    } else {
                        errorText = new Label("Error: The teacher is already in the list or one of the fields is incorrect");
                        add(errorText);
                    }
                } catch (NumberFormatException tryevent) {
                    errorText = new Label("Error: some of the fields must be numeric");
                    add(errorText);
                }
                setSize(720, 251); setSize(720, 250);
            });
            btnCancelAdd.addActionListener(event -> {addPanel.removeAll();highPanel.removeAll();checkboxPanel.removeAll();
                if (errorText != null) {remove(errorText);}setSize(720, 251); setSize(720, 250);});
        } else if (e.getSource() == chkCollage && chkCollage.getState()) {
            if (highPanel == null) {
                highPanel = new Panel();
            } else {
                highPanel.removeAll();
            }

            lblTeacherTitle = new Label("Teacher Title:");
            txtTeacherTitle = new TextField(20);
            lblTeacherYears = new Label("Teacher Years:");
            txtTeacherYears = new TextField(20);
            btnSaveAdd = new Button("Save");
            btnCancelAdd = new Button("Cancel");

            highPanel.add(lblTeacherTitle);
            highPanel.add(txtTeacherTitle);
            highPanel.add(lblTeacherYears);
            highPanel.add(txtTeacherYears);

            highPanel.add(btnSaveAdd);
            highPanel.add(btnCancelAdd);

            add(highPanel);

            btnSaveAdd.addActionListener(event -> {
                try {
                    if (Integer.parseInt(txtTeacherExp.getText()) < 60 && Integer.parseInt(txtTeacherYears.getText()) < 100
                            && !searchForTeacher(txtTeacherName.getText())) {
                        teachersList.add(new CollegeTeacher(txtTeacherName.getText(), Integer.parseInt(txtTeacherExp.getText()),
                                txtTeacherTitle.getText(), Integer.parseInt(txtTeacherYears.getText())));
                        updateList();
                        addPanel.removeAll();highPanel.removeAll();checkboxPanel.removeAll();
                        if (errorText != null) {remove(errorText);}setSize(720, 251); setSize(720, 250);
                    } else {
                        errorText = new Label("Error: The teacher is already in the list or one of the fields is incorrect");
                        add(errorText);
                    }
                } catch (NumberFormatException tryevent) {
                    errorText = new Label("Error: some of the fields must be numeric");
                    add(errorText);
                }
                setSize(720, 251); setSize(720, 250);
            });
            btnCancelAdd.addActionListener(event -> {addPanel.removeAll();highPanel.removeAll();checkboxPanel.removeAll();
                if (errorText != null) {remove(errorText);} setSize(720, 251); setSize(720, 250);});
        }
        validate();
    }

    private void initializeModPanel() {
        if (specificModPanel != null) {
            specificModPanel.removeAll();
            remove(specificModPanel);
        }
        if (modPanel != null) {
            modPanel.removeAll();
            remove(specificModPanel);
        }
        modPanel = new Panel();
        specificModPanel = new Panel();

        if (selectedTeacherUniversal != null && Objects.equals(selectedTeacherUniversal.getType(), "college")) {
            CollegeTeacher collegeTeacher = (CollegeTeacher) selectedTeacherUniversal;

            modLblTeacherName = new Label("Teacher Name:");
            modTxtTeacherName = new TextField(20);
            modLblTeacherExp = new Label("Teacher Experience:");
            modTxtTeacherExp = new TextField(20);
            modLblTeacherTitle = new Label("Teacher Title:");
            modTxtTeacherTitle = new TextField(20);
            modLblTeacherYears = new Label("Teacher Years:");
            modTxtTeacherYears = new TextField(20);
            btnSaveMod = new Button("Save");
            btnCancelMod = new Button("Cancel");

            modPanel.add(modLblTeacherName);
            modPanel.add(modTxtTeacherName);
            modPanel.add(modLblTeacherExp);
            modPanel.add(modTxtTeacherExp);

            add(modPanel);

            specificModPanel.add(modLblTeacherTitle);
            specificModPanel.add(modTxtTeacherTitle);
            specificModPanel.add(modLblTeacherYears);
            specificModPanel.add(modTxtTeacherYears);
            specificModPanel.add(btnSaveMod);
            specificModPanel.add(btnCancelMod);

            add(specificModPanel);
            setSize(720, 251);

            modTxtTeacherName.setText(collegeTeacher.getName());
            modTxtTeacherExp.setText(String.valueOf(collegeTeacher.getExperience()));
            modTxtTeacherTitle.setText(collegeTeacher.getTitle());
            modTxtTeacherYears.setText(String.valueOf(collegeTeacher.getYearsOfEmployment()));

            btnSaveMod.addActionListener(actionEvent -> {
                String modifiedName = modTxtTeacherName.getText();
                int modifiedExp = Integer.parseInt(modTxtTeacherExp.getText());
                String modifiedTitle = modTxtTeacherTitle.getText();
                int modifiedYears = Integer.parseInt(modTxtTeacherYears.getText());
                try {
                    if (modifiedExp < 60 && modifiedYears < 100) {
                        collegeTeacher.setName(modifiedName);
                        collegeTeacher.setExperience(modifiedExp);
                        collegeTeacher.setTitle(modifiedTitle);
                        collegeTeacher.setYearsOfEmployment(modifiedYears);

                        updateList();

                        modPanel.removeAll();
                        specificModPanel.removeAll();
                        remove(modPanel);
                        remove(specificModPanel);
                        if (errorText != null) {
                            remove(errorText);
                        }
                    } else {
                        errorText = new Label("Error: One of the fields is incorrect");
                        add(errorText);
                    }
                } catch (NumberFormatException e) {
                    errorText = new Label("Error: some of the fields must be numeric");
                    add(errorText);
                }
                setSize(720, 251); setSize(720, 250);
            });
            btnCancelMod.addActionListener(actionEvent -> {
                modPanel.removeAll();
                specificModPanel.removeAll();
                remove(modPanel);
                remove(specificModPanel);
                if (errorText != null) {
                    remove(errorText);
                }
                setSize(720, 250);
            });
        } else if (selectedTeacherUniversal != null && Objects.equals(selectedTeacherUniversal.getType(), "high")) {
            HighSchoolTeacher highSchoolTeacher = (HighSchoolTeacher) selectedTeacherUniversal;

            modLblTeacherName = new Label("Teacher Name:");
            modTxtTeacherName = new TextField(20);
            modLblTeacherExp = new Label("Teacher Experience:");
            modTxtTeacherExp = new TextField(20);
            modLblTeacherGrade = new Label("Teacher Grade:");
            modTxtTeacherGrade = new TextField(20);
            modLblTeacherHours = new Label("Teacher Hours:");
            modTxtTeacherHours = new TextField(20);
            btnSaveMod = new Button("Save");
            btnCancelMod = new Button("Cancel");

            modPanel.add(modLblTeacherName);
            modPanel.add(modTxtTeacherName);
            modPanel.add(modLblTeacherExp);
            modPanel.add(modTxtTeacherExp);

            add(modPanel);

            specificModPanel.add(modLblTeacherGrade);
            specificModPanel.add(modTxtTeacherGrade);
            specificModPanel.add(modLblTeacherHours);
            specificModPanel.add(modTxtTeacherHours);
            specificModPanel.add(btnSaveMod);
            specificModPanel.add(btnCancelMod);

            add(specificModPanel);
            setSize(720, 251);

            modTxtTeacherName.setText(highSchoolTeacher.getName());
            modTxtTeacherExp.setText(String.valueOf(highSchoolTeacher.getExperience()));
            modTxtTeacherGrade.setText(highSchoolTeacher.getGrade());
            modTxtTeacherHours.setText(String.valueOf(highSchoolTeacher.getNrOfHours()));

            btnSaveMod.addActionListener(actionEvent -> {
                String modifiedName = modTxtTeacherName.getText();
                int modifiedExp = Integer.parseInt(modTxtTeacherExp.getText());
                String modifiedGrade = modTxtTeacherGrade.getText();
                int modifiedHours = Integer.parseInt(modTxtTeacherHours.getText());
                try {
                    if (modifiedExp < 60 && modifiedHours < 40) {
                        highSchoolTeacher.setName(modifiedName);
                        highSchoolTeacher.setExperience(modifiedExp);
                        highSchoolTeacher.setGrade(modifiedGrade);
                        highSchoolTeacher.setNrOfHours(modifiedHours);

                        updateList();

                        modPanel.removeAll();
                        specificModPanel.removeAll();
                        remove(modPanel);
                        remove(specificModPanel);
                        if (errorText != null) {
                            remove(errorText);
                        }
                    } else {
                        errorText = new Label("Error: One of the fields is incorrect");
                        add(errorText);
                    }
                } catch (NumberFormatException e) {
                    errorText = new Label("Error: some of the fields must be numeric");
                    add(errorText);
                }
                setSize(720, 251); setSize(720, 250);
            });
            btnCancelMod.addActionListener(actionEvent -> {
                modPanel.removeAll();
                specificModPanel.removeAll();
                remove(modPanel);
                remove(specificModPanel);
                if (errorText != null) {
                    remove(errorText);
                }
                setSize(720, 250);
            });
        }
    }
    private void initializeDelPanel() {
        if (delPanel != null) {
            delPanel.removeAll();
            remove(delPanel);
        }
        delPanel = new Panel();
        delLblTeacherName = new Label("Teacher Name:");
        delTxtTeacherName = new TextField(20);
        delBtn = new Button("Delete");

        delPanel.add(delLblTeacherName);
        delPanel.add(delTxtTeacherName);
        delPanel.add(delBtn);

        delTxtTeacherName.setText(selectedTeacherUniversal.getName());
        Frame frame = new Frame("Delete Confirmation");

        delBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    teachersList.remove(selectedTeacherUniversal);
                    updateList();
                } else if (result == JOptionPane.NO_OPTION) {
                    System.out.println("User clicked No");
                }
            }
        });
    }
    private boolean searchForTeacher(String name) {
        for (Teacher teacher : teachersList) {
            if (Objects.equals(teacher.getName(), name))
                return true;
        }
        return false;
    }
    private void updateList() {
        list.removeAll();
        for (Teacher teacher : teachersList) {
            list.add(teacher.toString());
        }
    }
    private void saveToFile() {
        try (Formatter formatter = new Formatter(TEACHERS_FILE_PATH)) {
            for (Teacher teacher : teachersList) {
                formatter.format("%s%n", teacher.toFileString());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error creating file: " + e.getMessage());
            System.exit(1);
        }
        dispose();
    }
    public static void main(String[] args) {
        TeacherManagementApp app = new TeacherManagementApp("App");
    }
}
