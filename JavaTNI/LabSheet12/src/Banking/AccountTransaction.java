package Banking;

import java.io.*;
import java.util.Scanner;

public class AccountTransaction extends BankAccount implements Transactionable {
    public AccountTransaction(String accId) throws FileNotFoundException {
        super(accId);

        File file = new File(super.getFilename());
        Scanner sc = new Scanner(file);

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

    @Override
    public void deposit(double amount) throws IOException {
        super.setAccBalance(super.getAccBalance() + amount);
        updateFile(super.getAccId(), amount, true);
    }

    @Override
    public void withdraw(double amount) throws IOException {
        if (super.getAccBalance() < amount) {

        } else {
            super.setAccBalance(super.getAccBalance() - amount);
            updateFile(super.getAccId(), amount, false);
        }
    }

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

    public void updateFile(String accId, double amount, boolean isDeposit) throws IOException {
        File file = new File(super.getFilename());

        Scanner sc = new Scanner(file);
        String newData = "";

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

        PrintWriter writer = new PrintWriter(new FileWriter(file));
        writer.print(newData);
        writer.close();
    }
}
