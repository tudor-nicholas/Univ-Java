package OOP.lab8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class run {
    public static void main(String[] args) throws FileNotFoundException {
        //Ex1
        System.out.println("1.Implement the hierarchy and test the polymorphism for a payable collection with objects from all classes.");
        System.out.println();
        Payable[] emplyees1 = {
                new CommissionEmployee("Cristian", "85492864", 1200, 15),
                new HourlyEmployee("Daniel", "84632885", 36, 15),
                new SalariedEmployee("Alex", "73427832", 1800),
                new Invoice(12, "Coca-Cola", 245000, 1200)
        };
        for (Payable p : emplyees1) {
            System.out.println(p);
        }
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println();
        //Ex2
        System.out.println("2.Implement the interface Comparable for employees depending on income. Load an employee collection and sort it.");
        System.out.println();
        //Before
        System.out.println("Before");
        System.out.println();
        Comparable[] employees2 = {
                new CommissionEmployee("Gabriel", "85973648", 28200, 15),
                new SalariedEmployee("Adelina", "86749648", 2700),
                new SalariedEmployee("Constantin", "38675937", 3400),
                new HourlyEmployee("Cristian", "59787395", 25, 40),
                new CommissionEmployee("Ciprian", "97578024", 45200, 15),
                new CommissionEmployee("Gabriel", "17593758", 8600, 15)
        };
        for (Comparable e: employees2) {
            System.out.println(e);
        }
        //After
        for (int i = 0; i < employees2.length - 1; i++) {
            for (int j = 0; j < employees2.length - i - 1; j++) {
                if (employees2[j].compare(employees2[j + 1]) > 0) {
                    Comparable temp = employees2[j];
                    employees2[j] = employees2[j + 1];
                    employees2[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("After");
        System.out.println();
        for (Comparable e: employees2) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println();
        //Ex3
        System.out.println("3.Load an objects collection, from the hierarchy of exercise 1, with data from a text file. Display polymorphic the collection. ");
        System.out.println();
        Payable[] employees3 = new Payable[6];
        int n=0;
        Scanner input = new Scanner(new File("D:\\Vs Code\\JavaJet\\src\\OOP\\lab8\\employees.txt"));
        while(input.hasNext()) {
            String line = input.nextLine();
            String[] type = line.split(" ");
            switch (type[0]) {
                case "hourly":
                    employees3[n] = new HourlyEmployee(type[1], type[2], Integer.parseInt(type[3]), Integer.parseInt(type[4]));
                    n++;
                    break;
                case "salaried":
                    employees3[n] = new SalariedEmployee(type[1], type[2], Double.parseDouble(type[3]));
                    n++;
                    break;
                case "commission":
                    employees3[n] = new CommissionEmployee(type[1], type[2], Integer.parseInt(type[3]), Integer.parseInt(type[4]));
                    n++;
                    break;
            }
        }
        for (Payable e: employees3) {
            System.out.println(e);
        }
    }
}
