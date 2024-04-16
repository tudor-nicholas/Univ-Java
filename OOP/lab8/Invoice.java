package OOP.lab8;

public class Invoice implements Payable {
    private int number;
    private String provider;
    private double value;
    private double TVAValue;

    public Invoice( int n, String p, double v, double tva ){
        number=n;
        provider = p;
        value = v;
        TVAValue=tva;
    }

    @Override
    public String toString(){
        return String.format("Invoice nr: %d Provider: %s Value: %.2f TVA: %.2f Pay:%.2f",
                number, provider, value, TVAValue, getPayment());
    }
    @Override
    public double getPayment() {
        return value+TVAValue;
    }

}
