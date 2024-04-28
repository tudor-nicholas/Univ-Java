package OOP.lab10;

public class BankAccount {
    private int accountNr;
    private String owner;
    private double balance;
    public BankAccount(int id, String name, double sum) {
        accountNr = id;
        owner = name;
        balance = sum;
    }

    public String toString(){
        return String.format("Bank Account: Nr: %d Registered to: %s Balance: %.2f", accountNr, owner, balance);
    }
}
