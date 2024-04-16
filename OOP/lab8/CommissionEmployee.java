package OOP.lab8;

public class CommissionEmployee extends Employee {
    private int sales;
    private int commission;
    public CommissionEmployee( String n, String ssn, int sale, int com ){
        super( n, ssn );
        setSales( sale );
        setCommission( com );
    }

    public void setCommission( int com ){
        if ( com > 0 && com < 100 )
            commission = com;
        else
            throw new IllegalArgumentException("The commission must be > 0 and < 100" );
    }
    public int getCommission(){
        return commission;
    }
    public void setSales( int s ){
        if ( sales >= 0 )
            sales = s;
        else
            throw new IllegalArgumentException("The sales must be >= 0" );
    }
    public int getSales(){
        return sales;
    }
    @Override
    public double getPayment(){
        return (double) (getCommission() * getSales()) /100;
    }
    @Override
    public String toString(){
        return String.format("Commission %s sales: %d commission: %d pay: %.2f",
                super.toString(), getSales(), getCommission(), getPayment() );
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
