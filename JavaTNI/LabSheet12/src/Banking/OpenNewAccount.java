package Banking;

import java.io.*;
import java.util.Scanner;

public class OpenNewAccount extends BankAccount {
    public OpenNewAccount(String accId, double accBalance) {
        super(accId, accBalance);
    }

    public String recordAccount() throws IOException {
        FileWriter file = new FileWriter(super.getFilename(), true);
        PrintWriter writer = new PrintWriter(file);

        if (isExistingAccount(super.getAccId())) {
            writer.close();
            return "This account has been created!!";
        } else {
            writer.println(getAccId() + "," + getAccBalance());
            writer.close();
            return "Created account success!!";
        }
    }

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
