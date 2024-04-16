package OOP.lab9;
import java.util.Scanner;

public class run {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Dan", 50.00);
        BankAccount account2 = new BankAccount( "Andrei", -7.53);

        System.out.println(account1);
        System.out.println(account2);

        Scanner input = new Scanner(System.in);
        double sum;

        System.out.print("Enter the sum to deposit in account1:");
        sum = input.nextDouble();

        System.out.printf("\nDeposit %.2f in account1\n\n",sum);
        account1.deposit(sum);

        System.out.println(account1);
        System.out.println(account2);

        System.out.print("Enter the sum to deposit in account2:");
        sum = input.nextDouble();

        System.out.printf("\nDeposit %.2f in account2\n\n",sum);
        account2.deposit(sum);

        System.out.println(account1);
        System.out.println(account2);

        System.out.print("Enter the sum to withdraw from account1:");
        sum = input.nextDouble();

        System.out.printf("\nWithdraw %.2f in account1\n\n",sum);
        account1.withdraw(sum);

        System.out.println(account1);
        System.out.println(account2);

        System.out.print("Enter the sum to withdraw from account2:");
        sum = input.nextDouble();

        System.out.printf("\nWithdraw %.2f in account2\n\n",sum);
        account2.withdraw(sum);

        System.out.println(account1);
        System.out.println(account2);
    }
}
