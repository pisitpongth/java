package Banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountTransaction extends BankAccount implements Transactionable {
    public AccountTransaction(String accId) {
        super(accId);
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
    public void deposit(double amount) {
        super.setAccBalance(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (super.getAccBalance() < amount) {

        } else {
            super.setAccBalance(amount);
        }
    }

    @Override
    public double checkBalance() {
        return super.getAccBalance();
    }
}
