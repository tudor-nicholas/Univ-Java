package OOP.lab5;

public class CommissionEmployee extends Employee{
    private int sales;
    private int commission;
    public CommissionEmployee( String fn, String sn, String ssn, int sale, int com ){
        super( fn, sn, ssn );
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
    public int income(){
        return getCommission() * getSales()/100;
    }
    @Override
    public String toString(){
        return String.format("Commission %s sales: %d commission: %d income: %d",
                super.toString(), getSales(), getCommission(), income() );
    }

}
