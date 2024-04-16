package OOP.lab4;

public class appSFunctions {
    public static Person findBiggestSalary(Person[] persons) {
        Person big = persons[0];
        for (int i = 0; i < persons.length; i++) {
            if (big.getSalary()<persons[i].getSalary()) {
                big = persons[i];
            }
        }
        return big;
    }
    public static void displayAll(Locality[] localities) {
        for (int i = 0; i < localities.length; i++) {
            localities[i].displayLocality();
            localities[i].displayPersons();
            System.out.println();
        }
    }
    public static void displayNameI(Locality[] localities) {
        for (int i = 0; i < localities.length; i++) {
            System.out.printf("Localitatea %s cu %d numar de persoane.\n", localities[i].getName(), localities[i].getPersons().length);
        }
    }
}
