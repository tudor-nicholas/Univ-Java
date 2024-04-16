package OOP.lab5;

public class AppE {

    public static void main(String[] args) {
        System.out.println("1. Add the classes HourlyEmployee and SalaryedCommissionEmployee from the hierarchy of Employees. The HourlyEmployee performs a number of hours and is payed at a certain hourly rate.");
        System.out.println("+");
        System.out.println("2. Modify the methods toString for displaying in addition, the earnings for every employee type.");
        System.out.println("---------------------------------------");
        Employee e1 = new Employee("Popescu", "Ion", "1234");
        System.out.println(e1);
        SalariedEmployee e2 = new SalariedEmployee("Popescu","Vasile","2345",2000);
        System.out.println(e2);
        CommissionEmployee e3 = new CommissionEmployee("Popescu", "Elena","4567",5000,5);
        System.out.println(e3);
        HourlyEmployee e4 = new HourlyEmployee("Ionescu", "Vlad", "8537", 36, 15);
        System.out.println(e4);
        SalariedCommisionEmployee e5 = new SalariedCommisionEmployee("Ionescu", "Mihai","4829",2500,8, 1500);
        System.out.println(e5);
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("3. Implement the class Triangle hierarchy given by the UML diagram.");
        Triangle t1 = new Triangle(5, 2,4);
        System.out.println(t1);
        EquilateralTriangle t2 = new EquilateralTriangle(4);
        System.out.println(t2);
        RightTriangle t3 = new RightTriangle(4,3);
        System.out.println(t3);

    }
}
