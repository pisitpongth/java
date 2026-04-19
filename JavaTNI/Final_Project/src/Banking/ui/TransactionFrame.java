package Banking.ui;

import Banking.logic.AccountTransaction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;

public class TransactionFrame extends JFrame {
    private JTextField accIdField, amountField;
    private JLabel balanceLabel, messageLabel;
    private JPanel menuPanel;
    private AccountTransaction account;

    public TransactionFrame() {
        setTitle("Transactions");
        setSize(420, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        add(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel titleLabel = new JLabel("Account Services", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        accIdField = new JTextField();
        JButton loginBtn = new JButton("Secure Login");
        messageLabel = new JLabel(" ", SwingConstants.CENTER);

        menuPanel = new JPanel(new GridBagLayout());
        menuPanel.setVisible(false); // Hidden until login success
        menuPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Actions", TitledBorder.LEFT, TitledBorder.TOP));
        buildMenuPanel();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(new JLabel("Account ID:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(accIdField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        mainPanel.add(loginBtn, gbc);

        gbc.gridy = 3;
        mainPanel.add(messageLabel, gbc);

        gbc.gridy = 4;
        mainPanel.add(menuPanel, gbc);

        loginBtn.addActionListener(e -> handleLogin());
        setVisible(true);
    }

    private void buildMenuPanel() {
        // Setup internal menu UI components
        GridBagConstraints mgbc = new GridBagConstraints();
        mgbc.insets = new Insets(10, 5, 10, 5);
        mgbc.fill = GridBagConstraints.HORIZONTAL;
        mgbc.weightx = 0.5;

        amountField = new JTextField();
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton checkBtn = new JButton("Refresh Balance");

        balanceLabel = new JLabel("Balance: $0.00", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        balanceLabel.setForeground(new Color(41, 128, 185));

        mgbc.gridx = 0;
        mgbc.gridy = 0;
        menuPanel.add(new JLabel("Amount:"), mgbc);
        mgbc.gridx = 1;
        menuPanel.add(amountField, mgbc);

        mgbc.gridy = 1;
        mgbc.gridx = 0;
        menuPanel.add(depositBtn, mgbc);
        mgbc.gridx = 1;
        menuPanel.add(withdrawBtn, mgbc);

        mgbc.gridy = 2;
        mgbc.gridx = 0;
        mgbc.gridwidth = 2;
        menuPanel.add(checkBtn, mgbc);

        mgbc.gridy = 3;
        menuPanel.add(balanceLabel, mgbc);

        depositBtn.addActionListener(e -> handleDeposit());
        withdrawBtn.addActionListener(e -> handleWithdraw());
        checkBtn.addActionListener(e -> handleCheckBalance());
    }

    private void handleLogin() {
        String accId = accIdField.getText().trim();
        try {
            account = new AccountTransaction(accId);
            if (account.hasAccountId()) {
                messageLabel.setForeground(new Color(39, 174, 96));
                messageLabel.setText("Access Granted");
                menuPanel.setVisible(true);
                pack();
                setSize(420, getHeight()); // Maintain fixed width
            } else {
                messageLabel.setForeground(new Color(192, 57, 43));
                messageLabel.setText("Account Not Found");
                menuPanel.setVisible(false);
            }
        } catch (IOException ex) {
            messageLabel.setText("Error: " + ex.getMessage());
        }
    }

    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText().trim());
            account.deposit(amount);
            updateBalanceDisplay();
        } catch (Exception ex) {
            balanceLabel.setText("Invalid Input");
        }
    }

    private void handleWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText().trim());
            account.withdraw(amount);
            updateBalanceDisplay();
        } catch (Exception ex) {
            balanceLabel.setText("Invalid Input");
        }
    }

    private void handleCheckBalance() {
        try {
            updateBalanceDisplay();
        } catch (IOException ex) {
            balanceLabel.setText("Error");
        }
    }

    private void updateBalanceDisplay() throws IOException {
        balanceLabel.setText("Current Balance: $" + String.format("%.2f", account.checkBalance()));
    }
}