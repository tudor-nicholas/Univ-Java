package OOP.lab4;

public class Person {
    private String name;
    private int salary;
    public Person(String name,int salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return  salary;
    }
    public void display() {
        System.out.printf("Persoana: %s, cu salariul de %d\n", name, salary);
    }
}
