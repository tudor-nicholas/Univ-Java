package OOP.lab9;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Formatter;

public class SavePerson {
    private static Person[] collection = new Person[50];
    private static int n;

    private static void loadFile() {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("D:\\Vs Code\\JavaJet\\src\\OOP\\lab9\\Persons.txt")); // Open the file for reading
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
            System.exit(1);
        }

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0] + " " + parts[1];
            int income = Integer.parseInt(parts[2]);
            collection[n++] = new Person(name, income);
        }
        fileScanner.close();
    }

    private static void saveCollection() {
        try (Formatter formatter = new Formatter("D:\\Vs Code\\JavaJet\\src\\OOP\\lab9\\persons.txt")) {
            for (int i = 0; i < n; i++) {
                formatter.format("%s%n", collection[i]);
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            System.exit(1);
        }
    }
    public static void displayCollection() {
        for (int i = 0; i < n; i++) {
            System.out.println(collection[i]);
        }
    }
    public static void loadFromKeyboard(int numberOfPeople) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("Enter last name:");
            String lastName = scan.nextLine();
            System.out.println("Enter first name:");
            String firstName = scan.nextLine();
            int income;
            while (true) {
                try {
                    System.out.println("Enter income:");
                    income = scan.nextInt();
                    break; // Exit the loop if input is successfully parsed
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for income.");
                    scan.nextLine(); // Consume the invalid input
                }
            }
            String name = lastName + " " + firstName;
            collection[n++] = new Person(name, income);
            scan.nextLine(); // Consume the newline character
        }
        scan.close();
    }
    public static void enterFromDialogWindow() {
        String name,sSalary;
        int salary;
        name=JOptionPane.showInputDialog("Enter name");
        sSalary= JOptionPane.showInputDialog("Enter salary");
        salary=Integer.parseInt(sSalary);
        collection[n++] = new Person(name, salary);
    }

    public static void main(String[] args) {
        loadFile();
        System.out.println("Collection loaded from file");
        displayCollection();
        /*collection[n++] = new Person("Popescu Eugen", 20000);
        collection[n++] = new Person("Ionescu Dana", 25000);
        System.out.println("\nAppend 2 persons in the collection");
        displayCollection();*/
        //Ex1
        /*System.out.println();
        System.out.println("1.Add a new person in the collection with data from the keyboard. ");
        System.out.println();
        int numberOfPeople = 2;
        loadFromKeyboard(numberOfPeople);*/
        //Ex2
        System.out.println();
        System.out.println("2.Add a new person in the collection with data from a dialog window.");
        System.out.println();
        enterFromDialogWindow();
        displayCollection();
        System.out.println("\nSave the collection");
        saveCollection();
    }
}
