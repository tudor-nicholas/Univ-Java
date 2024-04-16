package OOP.lab8;

public class HourlyEmployee extends Employee {
    private int hours;
    private int hourRate;
    public HourlyEmployee( String n, String ssn, int h, int hr){
        super( n, ssn );
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
    public double getPayment(){
        return getHours() * getHourRate();
    }

    @Override
    public String toString(){
        return String.format("Hourly %s hours: %d hourly rate: %d pay: %.2f",
                super.toString(),getHours(),getHourRate(),getPayment() );
    }
    @Override
    public int compare(Comparable c) {
        if (c instanceof Employee e) {
            if (this.getPayment() > e.getPayment()) {
                return 1;
            } else if (this.getPayment() < e.getPayment()) {
                return -1;
            }
        }
        return -1;
    }
}
