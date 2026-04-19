package Banking.logic;

// Base class that holds basic bank account info
public class BankAccount {
    private String accId;
    private double accBalance;
    // Path to the file that stores all accounts
    private final String filename = "src/Banking/users_account.txt";

    // Create account with both id and balance
    public BankAccount(String accId, double accBalance) {
        this.accId = accId;
        this.accBalance = accBalance;
    }

    // Create account with only id, balance starts at 0
    public BankAccount(String accId) {
        this.accId = accId;
        this.accBalance = 0;
    }

    // Create empty account
    public BankAccount() {
        this.accId = "";
        this.accBalance = 0;
    }

    public String getAccId() {
        return this.accId;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public double getAccBalance() {
        return this.accBalance;
    }

    public String getFilename() {
        return this.filename;
    }

    // Return account info as a single line (used when writing to file)
    public String toString() {
        return this.accId + "," + this.accBalance;
    }
}
