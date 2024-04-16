package OOP.lab5;

public class SalariedEmployee extends  Employee{
    private int salary;

    public SalariedEmployee( String fn, String sn, String ssn,int s){
        super( fn, sn, ssn );
        salary=s;
    }

    public void setSalary( int s ){
        if ( s >= 0 )
            salary = s;
        else
            throw new IllegalArgumentException("Salary must be >= 0" );
    }
    public int getSalary(){
        return salary;
    }

    @Override
    public int income(){
        return getSalary();
    }
    @Override
    public String toString(){
        return String.format("Salaried %s: salary %d income: %d",
                super.toString(), getSalary(), income() );
    }

}
