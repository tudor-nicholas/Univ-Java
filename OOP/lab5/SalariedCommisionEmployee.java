package OOP.lab5;

public class SalariedCommisionEmployee extends CommissionEmployee{
    private int salary;

    public SalariedCommisionEmployee( String fn, String sn, String ssn, int sale, int com, int salary){
        super( fn, sn, ssn, sale, com );
        setSalary(salary);
    }
    public void setSalary(int s) {
        if ( s >= 0 )
            this.salary = s;
        else
            throw new IllegalArgumentException("The salary must be >= 0" );
    }
    public int getSalary() {
        return salary;
    }
    @Override
    public int income(){
        return super.income() + getSalary();
    }
    @Override
    public String toString(){
        return String.format("Salaried %s salary: %d income after salary: %d",
                super.toString(), getSalary(), income() );
    }
}
