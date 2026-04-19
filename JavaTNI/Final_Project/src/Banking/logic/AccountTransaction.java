package Banking.logic;

import java.io.*;
import java.util.Scanner;

// Handles deposit, withdraw, and balance check for an existing account
public class AccountTransaction extends BankAccount implements Transactionable {

    // Load the account from file and set the balance
    public AccountTransaction(String accId) throws FileNotFoundException {
        super(accId);

        File file = new File(super.getFilename());
        Scanner sc = new Scanner(file);

        // Find the matching account id and read its balance
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            if (parts[0].equals(accId)) {
                double balance = Double.parseDouble(parts[1]);
                setAccBalance(balance);
                break;
            }
        }
        sc.close();
    }

    // Check if the account id exists in the file
    public boolean hasAccountId() throws FileNotFoundException {
        File file = new File(super.getFilename());
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String[] data = sc.nextLine().split(",");

            if (super.getAccId().equalsIgnoreCase(data[0])) {
                sc.close();
                return true;
            }
        }
        sc.close();
        return false;
    }

    // Add money to the account
    @Override
    public void deposit(double amount) throws IOException {
        super.setAccBalance(super.getAccBalance() + amount);
        updateFile(super.getAccId(), amount, true);
    }

    // Remove money from the account (only if balance is enough)
    @Override
    public void withdraw(double amount) throws IOException {
        if (super.getAccBalance() < amount) {
            // Not enough balance, do nothing
        } else {
            super.setAccBalance(super.getAccBalance() - amount);
            updateFile(super.getAccId(), amount, false);
        }
    }

    // Read and return the current balance from the file
    @Override
    public double checkBalance() throws FileNotFoundException {
        File file = new File(super.getFilename());
        Scanner sc = new Scanner(file);

        double account_balance = 0;

        while (sc.hasNext()) {
            String[] data = sc.nextLine().split(",");
            String account_id = data[0];
            account_balance = Double.parseDouble(data[1]);

            if (super.getAccId().equalsIgnoreCase(account_id)) {
                break;
            }
        }
        sc.close();
        return account_balance;
    }

    // Update the balance in the file after deposit or withdraw
    public void updateFile(String accId, double amount, boolean isDeposit) throws IOException {
        File file = new File(super.getFilename());

        Scanner sc = new Scanner(file);
        String newData = "";

        // Read all lines and update the matching account
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            String account_id = parts[0];
            double balance = Double.parseDouble(parts[1]);

            if (account_id.equals(accId)) {
                if (isDeposit) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }

            newData += account_id + "," + balance + "\n";
        }

        sc.close();

        // Write the updated data back to the file
        PrintWriter writer = new PrintWriter(new FileWriter(file));
        writer.print(newData);
        writer.close();
    }
}
