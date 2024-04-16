package OOP.lab4;

public class Locality {
    private String name;
    private double surface;
    private String country;
    private Person[] persons;

    public Locality(String name, double surface, String country, Person[] persons) {
        this.name = name;
        this.surface = surface;
        this.country = country;
        this.persons = persons;
    }
    public String getName() {
        return name;
    }
    public double getSurface() {
        return surface;
    }
    public String getCountry() {
        return country;
    }
    public Person[] getPersons() {
        return persons;
    }
    public void addPerson(Person person) {
        Person[] placeHolder = new Person[persons.length + 1];
        for (int i = 0; i < persons.length; i++) {
            placeHolder[i] = persons[i];
        }
        placeHolder[persons.length] = person;
        persons = placeHolder;
    }
    public void displayPersonsEx2() {
        System.out.printf("Localitatea %s din %s.\n", name, country);
        for (int i = 0; i < persons.length; i++) {
            persons[i].display();
        }
    }
    public void displayLocality() {
        System.out.printf("Localiatea %s, se afla in %s, are o suprafata de %.2f si aproximativ %d persoane.\n", name, country, surface, persons.length);
    }
    public void displayPersons() {
        for (int i = 0; i < persons.length; i++) {
            System.out.print("  ");
            persons[i].display();
        }
    }
}
