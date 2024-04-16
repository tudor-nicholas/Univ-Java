package OOP.lab8;

public abstract class Employee implements Payable, Comparable {
    private String name;
    private String ssn;

    public Employee( String n, String ssn ){
        name = n;
        this.ssn = ssn;
    }
    @Override
    public String toString(){
        return String.format( "Employee %s ssn: %s", name, ssn );
    }

}
