package OOP.lab4;

public class App {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Vlad", 1900),
                new Person("Aurelian", 3200),
                new Person("Mihai", 2100),
                new Person("Andrei", 2800)
        };
        Person[] personsI = {
                new Person("Marco", 3400),
                new Person("Alessandro", 2600),
                new Person("Giuseppe", 4100),
                new Person("Flavio", 2900)
        };
        //Ex1
        System.out.println("Ex1: Create a static method which receives as argument a collection of persons and return the person with the greatest salary.");
        Person big = appSFunctions.findBiggestSalary(persons);
        big.display();
        System.out.println("----------");
        //Ex2
        System.out.println("Ex2: Display the persons from the collection. The display will contain the locality name and the county. ");
        System.out.println();
        Locality[] localities = {
                new Locality("Constanta", 65200, "Romania", persons),
                new Locality("Roma", 546000, "Italia", personsI)
        };
        localities[0].displayPersonsEx2();
        System.out.println("----------");
        //Ex3
        System.out.println("Ex3: Display all the localities from the collection");
        System.out.println();
        appSFunctions.displayAll(localities);
        System.out.println("----------");
        //Ex4
        System.out.println("Ex4: Display all the localities from the collection (name and number of inhabitants).");
        System.out.println();
        appSFunctions.displayNameI(localities);

    }
}
