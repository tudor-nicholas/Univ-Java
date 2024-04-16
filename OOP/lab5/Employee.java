package OOP.lab5;

public class Employee {
    private String firstName;
    private String secondName;
    private String ssn;

    public Employee( String fn, String sn, String ssn) {
        firstName = fn;
        secondName = sn;
        this.ssn = ssn;
    }
    public void setFirstName( String fn){
        firstName = fn;
    }
    public String getFirstNume() {
        return firstName;
    }
    public void setSecondName( String sn ) {
        secondName = sn;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSSN( String ssn ) {
        this.ssn = ssn;
    }
    public String getSSN() {
        return ssn;
    }
    public int income() {
        return 0 ;
    }
    public String toString(){
        return String.format("Employee: %s %s ssn: %s",firstName, secondName, ssn);
    }

}
