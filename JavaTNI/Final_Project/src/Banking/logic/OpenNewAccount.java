package Banking.logic;

import java.io.*;
import java.util.Scanner;

// Handles creating a new bank account and saving it to the file
public class OpenNewAccount extends BankAccount {

    public OpenNewAccount(String accId, double accBalance) {
        super(accId, accBalance);
    }

    // Save the new account to the file if it does not exist yet
    public String recordAccount() throws IOException {
        FileWriter file = new FileWriter(super.getFilename(), true);
        PrintWriter writer = new PrintWriter(file);

        if (isExistingAccount(super.getAccId())) {
            // Account already exists, do not add again
            writer.close();
            return "This account has been created!!";
        } else {
            // Write the new account to the file
            writer.println(getAccId() + "," + getAccBalance());
            writer.close();
            return "Created account success!!";
        }
    }

    // Check if the account id is already in the file
    private boolean isExistingAccount(String account_name) throws FileNotFoundException {
        File file = new File(super.getFilename());
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String[] data = sc.nextLine().split(",");

            if (data[0].equalsIgnoreCase(account_name)) {
                sc.close();
                return true;
            }
        }
        sc.close();
        return false;
    }
}
