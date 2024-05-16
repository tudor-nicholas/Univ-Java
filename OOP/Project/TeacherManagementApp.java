package OOP.Project;

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
    private Checkbox chkAdd, chkMod, chkDel;
    private CheckboxGroup cg;
    private Label lblTeacherName, lblTeacherExp, lblTeacherGrade, lblTeacherHours, lblTeacherTitle, lblTeacherYears,
            modLblTeacherName, modLblTeacherExp, modLblTeacherTitle, modLblTeacherYears, modLblTeacherGrade,
            modLblTeacherHours, delLblTeacherName;
    private TextField txtTeacherName, txtTeacherExp, txtTeacherGrade, txtTeacherHours, txtTeacherTitle, txtTeacherYears,
            modTxtTeacherName, modTxtTeacherExp, modTxtTeacherTitle, modTxtTeacherYears, modTxtTeacherGrade,
            modTxtTeacherHours, delTxtTeacherName;
    private Button btnHighSchool, btnCollege, btnSaveAdd, btnCancelAdd, modSearch, btnSaveMod, btnCancelMod, btnSave,
            btnExit, delBtn;
    private Panel addPanel, highPanel, modPanel, specificModPanel, delPanel, saveButtonPanel;
    private ArrayList<Teacher> teachersList;

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

        cg = new CheckboxGroup();
        chkAdd = new Checkbox("Add Teacher", true, cg);
        chkMod = new Checkbox("Modify Teacher", false, cg);
        chkDel = new Checkbox("Delete Teacher", false, cg);

        Panel checkboxPanel = new Panel();
        checkboxPanel.add(chkAdd);
        checkboxPanel.add(chkMod);
        checkboxPanel.add(chkDel);

        chkAdd.addItemListener(this);
        chkMod.addItemListener(this);
        chkDel.addItemListener(this);

        add(checkboxPanel);

        btnSave = new Button("Save");
        btnExit = new Button("Exit");

        btnSave.addActionListener(e -> saveToFile());
        btnExit.addActionListener(e -> dispose());

        saveButtonPanel = new Panel();
        saveButtonPanel.add(btnSave);
        saveButtonPanel.add(btnExit);

        add(saveButtonPanel, BorderLayout.SOUTH);

        setSize(900, 320);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ArrayList<Teacher> readTeachersFromFile() {
        ArrayList<Teacher> teacherList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(TEACHERS_FILE_PATH))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] part = line.split(" ");
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
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == chkAdd && chkAdd.getState()) {
            if (modPanel != null) {
                remove(modPanel);
            }
            if (delPanel != null) {
                remove(delPanel);
            }
            initializeAddPanel();
            add(addPanel);
            validate();
        } else if (e.getSource() == chkMod && chkMod.getState()) {
            if (addPanel != null) {
                remove(addPanel);
            }
            if (delPanel != null) {
                remove(delPanel);
            }
            initializeModPanel();
            add(modPanel);
            validate();
        } else if (e.getSource() == chkDel && chkDel.getState()) {
            if (addPanel != null) {
                remove(addPanel);
            }
            if (modPanel != null) {
                remove(modPanel);
            }
            initializeDelPanel();
            add(delPanel);
            validate();
        }
    }
    private void initializeAddPanel() {
        addPanel = new Panel();
        lblTeacherName = new Label("Teacher Name:");
        txtTeacherName = new TextField(20);
        lblTeacherExp = new Label("Teacher Experience:");
        txtTeacherExp = new TextField(20);
        btnHighSchool = new Button("High School Teacher");
        btnCollege = new Button("College Teacher");

        addPanel.add(lblTeacherName);
        addPanel.add(txtTeacherName);
        addPanel.add(lblTeacherExp);
        addPanel.add(txtTeacherExp);
        addPanel.add(btnHighSchool);
        addPanel.add(btnCollege);

        btnHighSchool.addActionListener(e -> handleTeacherAddSelection(true));
        btnCollege.addActionListener(e -> handleTeacherAddSelection(false));
    }
    private void handleTeacherAddSelection(boolean isHighSchool) {
        if (isHighSchool) {
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

            btnSaveAdd.addActionListener(e -> {
                teachersList.add(new HighSchoolTeacher(txtTeacherName.getText(), Integer.parseInt(txtTeacherExp.getText()),
                        txtTeacherGrade.getText(), Integer.parseInt(txtTeacherHours.getText())));
                updateList();
            });
            btnCancelAdd.addActionListener(e -> highPanel.removeAll());
        } else {
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

            btnSaveAdd.addActionListener(e -> {
                teachersList.add(new CollegeTeacher(txtTeacherName.getText(), Integer.parseInt(txtTeacherExp.getText()),
                        txtTeacherTitle.getText(), Integer.parseInt(txtTeacherYears.getText())));
                updateList();
            });
            btnCancelAdd.addActionListener(e -> highPanel.removeAll());
        }
        validate();
    }
    private void initializeModPanel() {
        modPanel = new Panel();
        specificModPanel = new Panel();
        modLblTeacherName = new Label("Teacher Name:");
        modTxtTeacherName = new TextField(20);
        modSearch = new Button("Search");
        modLblTeacherExp = new Label("Teacher Experience:");
        modTxtTeacherExp = new TextField(20);

        modPanel.add(modLblTeacherName);
        modPanel.add(modTxtTeacherName);
        modPanel.add(modSearch);
        modPanel.add(modLblTeacherExp);
        modPanel.add(modTxtTeacherExp);

        modSearch.addActionListener(e -> {
            Teacher teacher = searchForTeacher(modTxtTeacherName.getText());
            if (Objects.equals(teacher.getType(), "college")) {
                CollegeTeacher collegeTeacher = (CollegeTeacher) teacher;

                modLblTeacherTitle = new Label("Teacher Title:");
                modTxtTeacherTitle = new TextField(20);
                modLblTeacherYears = new Label("Teacher Years:");
                modTxtTeacherYears = new TextField(20);
                btnSaveMod = new Button("Save");
                btnCancelMod = new Button("Cancel");

                specificModPanel.add(modLblTeacherTitle);
                specificModPanel.add(modTxtTeacherTitle);
                specificModPanel.add(modLblTeacherYears);
                specificModPanel.add(modTxtTeacherYears);
                specificModPanel.add(btnSaveMod);
                specificModPanel.add(btnCancelMod);

                add(specificModPanel);
                setSize(905, 320);

                modTxtTeacherExp.setText(String.valueOf(collegeTeacher.getExperience()));
                modTxtTeacherTitle.setText(collegeTeacher.getTitle());
                modTxtTeacherYears.setText(String.valueOf(collegeTeacher.getYearsOfEmployment()));

                btnSaveMod.addActionListener(actionEvent -> {
                    int modifiedExp = Integer.parseInt(modTxtTeacherExp.getText());
                    String modifiedTitle = modTxtTeacherTitle.getText();
                    int modifiedYears = Integer.parseInt(modTxtTeacherYears.getText());

                    collegeTeacher.setExperience(modifiedExp);
                    collegeTeacher.setTitle(modifiedTitle);
                    collegeTeacher.setYearsOfEmployment(modifiedYears);

                    updateList();
                });
                btnCancelMod.addActionListener(actionEvent -> {
                    specificModPanel.removeAll();
                    modTxtTeacherExp.setText("");
                    setSize(900, 320);
                });
            } else if (Objects.equals(teacher.getType(), "high")) {
                HighSchoolTeacher highSchoolTeacher = (HighSchoolTeacher) teacher;

                modLblTeacherGrade = new Label("Teacher Grade:");
                modTxtTeacherGrade = new TextField(20);
                modLblTeacherHours = new Label("Teacher Hours:");
                modTxtTeacherHours = new TextField(20);
                btnSaveMod = new Button("Save");
                btnCancelMod = new Button("Cancel");

                specificModPanel.add(modLblTeacherGrade);
                specificModPanel.add(modTxtTeacherGrade);
                specificModPanel.add(modLblTeacherHours);
                specificModPanel.add(modTxtTeacherHours);
                specificModPanel.add(btnSaveMod);
                specificModPanel.add(btnCancelMod);

                add(specificModPanel);
                setSize(905, 320);

                modTxtTeacherExp.setText(String.valueOf(highSchoolTeacher.getExperience()));
                modTxtTeacherGrade.setText(highSchoolTeacher.getGrade());
                modTxtTeacherHours.setText(String.valueOf(highSchoolTeacher.getNrOfHours()));

                btnSaveMod.addActionListener(actionEvent -> {
                    int modifiedExp = Integer.parseInt(modTxtTeacherExp.getText());
                    String modifiedGrade = modTxtTeacherGrade.getText();
                    int modifiedHours = Integer.parseInt(modTxtTeacherHours.getText());

                    highSchoolTeacher.setExperience(modifiedExp);
                    highSchoolTeacher.setGrade(modifiedGrade);
                    highSchoolTeacher.setNrOfHours(modifiedHours);

                    updateList();
                });
                btnCancelMod.addActionListener(actionEvent -> {
                    specificModPanel.removeAll();
                    modTxtTeacherExp.setText("");
                    setSize(900, 320);
                });
            }
        });
    }
    private void initializeDelPanel() {
        delPanel = new Panel();
        delLblTeacherName = new Label("Teacher Name:");
        delTxtTeacherName = new TextField(20);
        delBtn = new Button("Delete");

        delPanel.add(delLblTeacherName);
        delPanel.add(delTxtTeacherName);
        delPanel.add(delBtn);

        delBtn.addActionListener(e -> {
            Teacher delTeacher = searchForTeacher(delTxtTeacherName.getText());
            teachersList.remove(delTeacher);
            updateList();
        });
    }
    private Teacher searchForTeacher(String name) {
        for (Teacher teacher : teachersList) {
            if (Objects.equals(teacher.getName(), name))
                return teacher;
        }
        return null;
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
    }
    public static void main(String[] args) {
        TeacherManagementApp app = new TeacherManagementApp("App");
    }
}
