package OOP.lab5;

public class HourlyEmployee extends Employee {
    private int hours;
    private int hourRate;
    public HourlyEmployee( String fn, String sn, String ssn, int h, int hr){
        super( fn, sn, ssn );
        setHours(h);
        setHourRate(hr);
    }
    public void setHours(int hours) {
        if ( hours >= 0 )
            this.hours = hours;
        else
            throw new IllegalArgumentException("The hours must be >= 0" );
    }
    public void setHourRate(int rate) {
        if ( rate >= 0 )
            hourRate = rate;
        else
            throw new IllegalArgumentException("The hourly rate must be >= 0" );
    }
    public int getHours() {
        return hours;
    }
    public int getHourRate() {
        return hourRate;
    }

    @Override
    public int income(){
        return getHours() * getHourRate();
    }

    @Override
    public String toString(){
        return String.format("Hourly %s hours: %d hourly rate: %d income: %d",
                super.toString(),getHours(),getHourRate(),income() );
    }
}
