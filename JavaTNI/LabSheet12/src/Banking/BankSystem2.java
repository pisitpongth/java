package Banking;

import java.io.IOException;
import java.util.Scanner;

public class BankSystem2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean is_loop = false;

        System.out.print("Enter your bank account: ");
        String account_id = sc.nextLine();

        AccountTransaction account = new AccountTransaction(account_id);

        if (account.hasAccountId()) {
            System.out.println();
            System.out.println("Press 1 to deposit" +
                    "\nPress 2 to withdraw" +
                    "\nPress 3 to check balance" +
                    "\nPress 4 to exit");
            System.out.println();

            while (!is_loop) {
                System.out.print("Enter a menu: ");
                int menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double deposit_amount = sc.nextDouble();
                        account.deposit(deposit_amount);
                        System.out.println("Your balance = " + account.checkBalance());
                        System.out.println();
                        continue;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw_amount = sc.nextDouble();
                        account.withdraw(withdraw_amount);
                        System.out.println("Your balance = " + account.checkBalance());
                        System.out.println();
                        continue;
                    case 3:
                        System.out.println("Your balance = " + account.checkBalance());
                        System.out.println();
                        continue;
                    case 4:
                        is_loop = true;
                }
            }
        } else {
            System.out.println();
            System.out.println("Bank account not found...");
        }
    }
}
