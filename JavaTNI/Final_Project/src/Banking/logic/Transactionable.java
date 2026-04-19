package Banking.logic;

import java.io.FileNotFoundException;
import java.io.IOException;

// Interface that defines what a bank account can do
public interface Transactionable {
    public void deposit(double amount) throws IOException;

    public void withdraw(double amount) throws IOException;

    public double checkBalance() throws FileNotFoundException;
}
