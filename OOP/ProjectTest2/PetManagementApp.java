package OOP.ProjectTest2;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;
import java.util.Scanner;

public class PetManagementApp extends Frame {
    private static final String PETS_FILE_PATH = "D:\\Vs Code\\JavaJet\\src\\OOP\\ProjectTest2\\pets.txt";
    private List list;
    private Label lblPetIndex;
    private TextField txtPetIndex, resultText;
    private Button btnExit, deleteBtn, loadBtn;
    private Panel mainPanel, modPanel;
    private ArrayList<Pet> petsList;

    public PetManagementApp(String title) {
        super(title);
        setLayout(new FlowLayout());

        list = new List();
        list.setFont(new Font("Arial", Font.PLAIN, 12));
        add(list);

        mainPanel = new Panel();
        lblPetIndex = new Label("Pet Index:");
        txtPetIndex = new TextField(20);
        deleteBtn = new Button("Delete");
        deleteBtn.addActionListener(e -> buttonControl("delete"));
        btnExit = new Button("Exit");
        btnExit.addActionListener(e -> saveToFile());
        loadBtn = new Button("Load");
        loadBtn.addActionListener(e -> loadPets());
        resultText = new TextField(30);
        resultText.setEditable(false);
        mainPanel.add(lblPetIndex);
        mainPanel.add(txtPetIndex);
        mainPanel.add(deleteBtn);
        mainPanel.add(loadBtn);
        mainPanel.add(btnExit);
        mainPanel.add(resultText);
        add(mainPanel);

        setSize(600, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ArrayList<Pet> readPetsFromFile() {
        ArrayList<Pet> petList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(PETS_FILE_PATH))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] part = line.split("  ");
                switch (part[0]) {
                    case "cat":
                        petList.add(new Cat(part[1], Integer.parseInt(part[2]), part[3], Integer.parseInt(part[4])));
                        break;
                    case "dog":
                        petList.add(new Dog(part[1], Integer.parseInt(part[2]), part[3], Integer.parseInt(part[4])));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return petList;
    }

    private void loadPets() {
        petsList = readPetsFromFile();
        updateList();
        setSize(601, 250);
    }

    public void buttonControl(String type) {
        if (Objects.equals(type, "delete")) {
            deletePet();
            validate();
        }
    }

    private void deletePet() {
        String indexStr = txtPetIndex.getText();
        try {
            int index = Integer.parseInt(indexStr) - 1;
            if (index >= 0 && index < petsList.size()) {
                petsList.remove(index);
                resultText.setText("Deletion successful");
            } else {
                resultText.setText("Invalid index");
            }
        } catch (NumberFormatException e) {
            resultText.setText("Invalid input");
        }
        updateList();
    }

    private void updateList() {
        list.removeAll();
        for (Pet pet : petsList) {
            list.add(pet.toString());
        }
    }

    private void saveToFile() {
        try (Formatter formatter = new Formatter(PETS_FILE_PATH)) {
            for (Pet pet : petsList) {
                formatter.format("%s%n", pet.toFileString());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error creating file: " + e.getMessage());
            System.exit(1);
        }
        dispose();
    }

    public static void main(String[] args) {
        PetManagementApp app = new PetManagementApp("Pet Management App");
    }
}

