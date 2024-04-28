package OOP.lab9;

public class BankAccount {
    private String owner;
    private double amount;

    public BankAccount(String o, double s ) {
        if (s > 0.0 ){
            amount = s;
        };
        owner = o;
    }
    public void deposit(double s) {
        amount = amount + s;
    }
    public String getOwner() {
        return owner;
    }
    public double getAmount(){
        return amount;
    }
    @Override
    public String toString(){
        return String.format("Account 1: Name: %s Balance: %.2f",
                owner, amount );
    }
    public void withdraw(double n) {
        if (n<=amount){
            amount -= n;
            System.out.println("You have withdraw " + n);
        } else {
            System.out.println("Withdraw amount exceeds the account balance.");
        }
    }

}
