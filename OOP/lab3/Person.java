package OOP.lab3;

public class Person {
    private String name;
    private double salary;

    public Person(String n, double s){
        name = n;
        salary = s;
    }

    public double getSalary(){
        return salary;
    }

    public void display(){
        System.out.printf("%s %.2f\n",name,salary);
    }

}
