package OOP.lab3;

public class ex1 {
    public static void main(String[] args) {
        Person[] v = {new Person("Ionescu Vasile", 1000),
                new Person("Popescu Dana", 1100),
                new Person("Barbu Alexandru", 1200),
                new Person("Stanciu Ionut", 1300),
                new Person("Neamtu Laurentiu", 1400)};
        double sum = 0;

        for (int i = 0; i < v.length; i++)
            v[i].display();

        for (int i = 0; i < v.length; i++)
            sum += v[i].getSalary();

        System.out.printf("\nThe sum of salaries is %.2f\n", sum);
    }

}
