package OOP.lab8;

public class SalariedEmployee extends Employee {
    private double salary;
    public SalariedEmployee( String n, String ssn, double s ){
        super( n, ssn );
        salary=s;
    }
    @Override
    public double getPayment(){
        return salary;
    }
    @Override
    public String toString(){
        return String.format("Salaried employee: %s Salary: %.2f Pay: %.2f",super.toString(), salary, getPayment());
    }
    @Override
    public int compare(Comparable c) {
        if (c instanceof Employee e) {
            if (getPayment() > e.getPayment()) {
                return 1;
            } else if (getPayment() < e.getPayment()) {
                return -1;
            }
        }
        return -1;
    }
}
