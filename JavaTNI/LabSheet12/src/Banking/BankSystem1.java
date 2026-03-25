package Banking;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystem1 {
    public static String input_account_id() {
        Scanner sc = new Scanner(System.in);
        boolean is_loop = false;
        String accId = "";

        while (!is_loop) {
            System.out.print("Enter account id: ");
            accId = sc.nextLine();

            if (accId.length() != 10) {
            } else {
                is_loop = true;
            }
        }
        return accId;
    }

    public static double input_initial_balance() {
        Scanner sc = new Scanner(System.in);
        boolean is_loop = false;
        double balance = 0;

        while (!is_loop) {
            try {
                System.out.print("Enter your initial deposit amount: ");
                balance = sc.nextDouble();
                is_loop = true;

            } catch (InputMismatchException e) {
                System.out.print("Try again!! ");
                sc.next();
            }
        }
        sc.close();
        return balance;
    }

    public static void main(String[] args) throws IOException {
        String account_bank = input_account_id();
        double initial_balance = input_initial_balance();

        OpenNewAccount account = new OpenNewAccount(account_bank, initial_balance);

        System.out.println();
        System.out.println(account.recordAccount());
    }
}
