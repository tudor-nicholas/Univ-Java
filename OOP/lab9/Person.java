package OOP.lab9;

public class Person {
    private String name;
    private int income;

    public Person(String n, int i) {
        name=n;
        income=i;
    }
    public String toString(){
        return String.format("%s %d", name, income);
    }
}
