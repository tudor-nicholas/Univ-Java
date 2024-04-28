package OOP.Project;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TeacherManagementApp extends Frame implements ItemListener {
    private List list;
    private Checkbox chkAdd, chkMod, chkDel;
    private CheckboxGroup cg;
    private Label lblTeacherName, lblTeacherExp, lblTeacherGrade, lblTeacherHours, lblTeacherTitle, lblTeacherYears;
    private TextField txtTeacherName, txtTeacherExp, txtTeacherGrade, txtTeacherHours, txtTeacherTitle, txtTeacherYears;
    private Button btnHighSchool, btnCollege, btnSaveAdd, btnCancelAdd;
    private Panel addPanel, highPanel;
    private ArrayList<Teacher> teachersList;

    public TeacherManagementApp(String title) {
        super(title);
        setLayout(new FlowLayout()); // Use FlowLayout to place components one after another

        list = new List();
        list.setFont(new Font("Arial", Font.PLAIN, 12));

        teachersList = readTeachersFromFile();
        for (Teacher teacher : teachersList) {
            list.add(teacher.toString());
        }

        add(list); // Add the list to the frame

        cg = new CheckboxGroup();
        chkAdd = new Checkbox("Add Teacher", true, cg);
        chkMod = new Checkbox("Modify Teacher", false, cg);
        chkDel = new Checkbox("Delete Teacher", false, cg);

        Panel checkboxPanel = new Panel(); // Create a panel to hold the checkboxes
        checkboxPanel.add(chkAdd);
        checkboxPanel.add(chkMod);
        checkboxPanel.add(chkDel);

        chkAdd.addItemListener(this); // Add item listener to the "Add Teacher" checkbox

        add(checkboxPanel); // Add the panel with checkboxes to the frame

        setSize(900, 320);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ArrayList<Teacher> readTeachersFromFile() {
        ArrayList<Teacher> teacherList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("D:\\Vs Code\\JavaJet\\src\\OOP\\Project\\teachers.txt"))) {
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

    // Item listener method to handle checkbox state changes
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == chkAdd && chkAdd.getState()) {
            initializeAddPanel();
            add(addPanel);
            validate();
        } else {
            remove(addPanel);
            validate();
        }
    }

    private void initializeAddPanel() {
        addPanel = new Panel(); // Initialize addPanel here
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

        btnHighSchool.addActionListener(e -> handleTeacherTypeSelection(true));
        btnCollege.addActionListener(e -> handleTeacherTypeSelection(false));
    }

    private void handleTeacherTypeSelection(boolean isHighSchool) {
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
    private void updateList() {
        list.removeAll();
        for (Teacher teacher : teachersList) {
            list.add(teacher.toString());
        }
    }
    public static void main(String[] args) {
        TeacherManagementApp app = new TeacherManagementApp("App");
    }
}





