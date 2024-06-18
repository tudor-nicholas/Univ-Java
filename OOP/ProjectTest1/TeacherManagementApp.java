package OOP.ProjectTest1;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;
import java.util.Scanner;

public class TeacherManagementApp extends Frame {
    private static final String TEACHERS_FILE_PATH = "D:\\Vs Code\\JavaJet\\src\\OOP\\ProjectTest1\\teachers.txt";
    private List list;
    private Label lblTeacherName;
    private TextField txtTeacherName, teacherIndex;
    private Button btnExit, modbtn, loadBtn;
    private Panel mainPanel, modPanel;
    private ArrayList<Teacher> teachersList;
    private Teacher selectedTeacherUniversal;
    public TeacherManagementApp(String title) {
        super(title);
        setLayout(new FlowLayout());

        list = new List();
        list.setFont(new Font("Arial", Font.PLAIN, 12));

//        teachersList = readTeachersFromFile();
//        for (Teacher teacher : teachersList) {
//            list.add(teacher.toString());
//        }

        add(list);

//        list.addItemListener(e -> {
//            if (e.getStateChange() == ItemEvent.SELECTED) {
//                int selectedIndex = list.getSelectedIndex();
//                if (selectedIndex != -1) {
//                    Teacher selectedTeacher = teachersList.get(selectedIndex);
//                    System.out.println("Selected teacher: " + selectedTeacher);
//                    selectedTeacherUniversal = selectedTeacher;
//                    if (modLblTeacherName != null) {
//                        buttonControl("mod");
//                    }
//                }
//            }
//        });

        mainPanel = new Panel();
        lblTeacherName = new Label("Teacher Name:");
        txtTeacherName = new TextField(20);
        modbtn = new Button("Search");
        modbtn.addActionListener(e -> buttonControl("mod"));
        btnExit = new Button("Exit");
        btnExit.addActionListener(e -> saveToFile());
        loadBtn = new Button("Load");
        loadBtn.addActionListener(e -> loadTeachers());
        mainPanel.add(lblTeacherName);
        mainPanel.add(txtTeacherName);
        mainPanel.add(modbtn);
        mainPanel.add(loadBtn);
        mainPanel.add(btnExit);
        add(mainPanel);

        setSize(600, 250);
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
    private void loadTeachers() {
        teachersList = readTeachersFromFile();
        list.removeAll();
        for (Teacher teacher : teachersList) {
            list.add(teacher.toString());
        }
        setSize(601, 250);
    }
    public void buttonControl(String type) {
        if (Objects.equals(type, "mod")) {
            initializeModPanel();
            validate();
        }
    }
    private void initializeModPanel() {
        if (modPanel != null) {
            modPanel.removeAll();
        }
        modPanel = new Panel();
        teacherIndex = new TextField(20);
        modPanel.add(teacherIndex);
        String position = searchForTeacher(txtTeacherName.getText());
        teacherIndex.setText(position);
        add(modPanel, BorderLayout.CENTER); // Add modPanel to the main layout
        revalidate();
        repaint();
    }
    private String searchForTeacher(String name) {
        for (int i = 0; i < teachersList.size(); i++) {
            if (Objects.equals(teachersList.get(i).getName(), name)) {
                int pos = i+1;
                return "Teacher found at index: " + pos;
            }
        }
        return "Teacher not found";
    }
    //    private boolean searchForTeacher(String name) {
//        for (Teacher teacher : teachersList) {
//            if (Objects.equals(teacher.getName(), name))
//                return true;
//        }
//        return false;
//    }
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
