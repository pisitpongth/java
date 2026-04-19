package Banking.ui;

import Banking.logic.OpenNewAccount;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Window for creating a new bank account
public class OpenAccountFrame extends JFrame {

    private JTextField accIdField;
    private JTextField balanceField;
    private JLabel messageLabel;

    public OpenAccountFrame() {
        setTitle("Open New Account");
        setSize(380, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Open New Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel accIdLabel = new JLabel("Account ID (10 digits):");
        accIdField = new JTextField(15);

        JLabel balanceLabel = new JLabel("Initial Deposit Amount:");
        balanceField = new JTextField(15);

        JButton createBtn = new JButton("Create Account");

        // Label to show success or error message
        messageLabel = new JLabel(" ");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(accIdLabel, gbc);
        gbc.gridx = 1;
        add(accIdField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        add(balanceLabel, gbc);
        gbc.gridx = 1;
        add(balanceField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(createBtn, gbc);

        gbc.gridy = 4;
        add(messageLabel, gbc);

        createBtn.addActionListener(e -> handleCreate());

        setVisible(true);
    }

    // Run when the user clicks Create Account
    private void handleCreate() {
        String accId = accIdField.getText().trim();
        String balanceText = balanceField.getText().trim();

        // Account id must be exactly 10 characters
        if (accId.length() != 10) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Account ID must be exactly 10 digits.");
            return;
        }

        // Balance must be a valid number
        double balance;
        try {
            balance = Double.parseDouble(balanceText);
        } catch (NumberFormatException ex) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Invalid deposit amount.");
            return;
        }

        // Try to create and save the account
        try {
            OpenNewAccount account = new OpenNewAccount(accId, balance);
            String result = account.recordAccount();
            messageLabel.setForeground(new Color(0, 128, 0));
            messageLabel.setText(result);
        } catch (IOException ex) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Error: " + ex.getMessage());
        }
    }
}
