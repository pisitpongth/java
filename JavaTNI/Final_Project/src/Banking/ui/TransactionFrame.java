package Banking.ui;

import Banking.logic.AccountTransaction;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Window for deposit, withdraw, and balance check
public class TransactionFrame extends JFrame {

    private JTextField accIdField;
    private JTextField amountField;
    private JLabel balanceLabel;
    private JLabel messageLabel;
    private JPanel menuPanel;
    private AccountTransaction account;

    public TransactionFrame() {
        setTitle("Account Transaction");
        setSize(400, 380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Account Transaction");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel accIdLabel = new JLabel("Enter your bank account:");
        accIdField = new JTextField(15);
        JButton loginBtn = new JButton("Login");

        // Label to show login result
        messageLabel = new JLabel(" ");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Menu panel is hidden until the user logs in
        menuPanel = new JPanel(new GridBagLayout());
        menuPanel.setVisible(false);
        buildMenuPanel();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        add(accIdLabel, gbc);
        gbc.gridx = 1;
        add(accIdField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(loginBtn, gbc);

        gbc.gridy = 3;
        add(messageLabel, gbc);

        gbc.gridy = 4;
        add(menuPanel, gbc);

        loginBtn.addActionListener(e -> handleLogin());

        setVisible(true);
    }

    // Build the deposit/withdraw/check balance buttons inside the menu panel
    private void buildMenuPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(12);

        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton checkBtn = new JButton("Check Balance");

        // Label to show the current balance
        balanceLabel = new JLabel(" ");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 13));
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        menuPanel.add(amountLabel, gbc);
        gbc.gridx = 1;
        menuPanel.add(amountField, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        menuPanel.add(depositBtn, gbc);
        gbc.gridx = 1;
        menuPanel.add(withdrawBtn, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        menuPanel.add(checkBtn, gbc);

        gbc.gridy = 3;
        menuPanel.add(balanceLabel, gbc);

        depositBtn.addActionListener(e -> handleDeposit());
        withdrawBtn.addActionListener(e -> handleWithdraw());
        checkBtn.addActionListener(e -> handleCheckBalance());
    }

    // Check if the account exists, then show the menu
    private void handleLogin() {
        String accId = accIdField.getText().trim();
        try {
            account = new AccountTransaction(accId);
            if (account.hasAccountId()) {
                messageLabel.setForeground(new Color(0, 128, 0));
                messageLabel.setText("Login successful!");
                menuPanel.setVisible(true);
                pack();
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Bank account not found...");
                menuPanel.setVisible(false);
            }
        } catch (IOException ex) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Error: " + ex.getMessage());
        }
    }

    // Add money to the account
    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText().trim());
            account.deposit(amount);
            balanceLabel.setText("Your balance = " + String.format("%.2f%n", account.checkBalance()));
        } catch (NumberFormatException ex) {
            balanceLabel.setText("Invalid amount.");
        } catch (IOException ex) {
            balanceLabel.setText("Error: " + ex.getMessage());
        }
    }

    // Remove money from the account
    private void handleWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText().trim());
            account.withdraw(amount);
            balanceLabel.setText("Your balance = " + String.format("%.2f%n", account.checkBalance()));
        } catch (NumberFormatException ex) {
            balanceLabel.setText("Invalid amount.");
        } catch (IOException ex) {
            balanceLabel.setText("Error: " + ex.getMessage());
        }
    }

    // Show the current balance
    private void handleCheckBalance() {
        try {
            balanceLabel.setText("Your balance = " + String.format("%.2f%n", account.checkBalance()));
        } catch (IOException ex) {
            balanceLabel.setText("Error: " + ex.getMessage());
        }
    }
}
