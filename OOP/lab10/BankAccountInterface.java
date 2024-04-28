package OOP.lab10;
import java.awt .*;
import java.awt.event.*;

public class BankAccountInterface extends Frame implements ActionListener  {
    private BankAccount[] bankAccounts = new BankAccount[50];
    private int numberOfAccounts = 0;
    private Label lOwner = new Label("Owner");
    private TextField txtOwner = new TextField(20);
    private Label lBalance = new Label("Balance");
    private TextField txtBalance = new TextField(20);
    private Button save = new Button("Save");
    private Button exit = new Button(" Exit ");
    private Label lMessage = new Label("               ");
    public BankAccountInterface(String title) {
        super(title);

        setLayout(new FlowLayout());

        add(lOwner);
        add(txtOwner);
        add(lBalance);
        add(txtBalance);
        add(save);
        add(exit);
        add(lMessage);

        save.addActionListener(this);
        exit.addActionListener(this);
        lMessage.setForeground(Color.RED);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            for (int i = 0; i < numberOfAccounts; i++)
                System.out.println(bankAccounts[i]);
            System.exit(0);
        }
        if (e.getSource() == save) {
            String owner = txtOwner.getText();
            String balanceStr = txtBalance.getText();

            if (owner.isEmpty()) {
                lMessage.setText("Fill Owner");
                return;
            }

            if (balanceStr.isEmpty()) {
                lMessage.setText("Fill Balance");
                return;
            }

            double balance;
            try {
                balance = Double.parseDouble(balanceStr);
            } catch (NumberFormatException ex) {
                lMessage.setText("Wrong balance");
                return;
            }

            lMessage.setText("");
            BankAccount account = new BankAccount(numberOfAccounts + 1, owner, balance);
            bankAccounts[numberOfAccounts++] = account;
            setTitle(numberOfAccounts + " accounts");
            txtOwner.setText("");
            txtBalance.setText("");
        }
    }
    public static void main(String[] args) {
        BankAccountInterface f = new BankAccountInterface("Bank Account Interface");
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
