package Banking.ui;

import Banking.logic.OpenNewAccount;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class OpenAccountFrame extends JFrame {
    private JTextField accIdField;
    private JTextField balanceField;
    private JLabel messageLabel;

    public OpenAccountFrame() {
        setTitle("Create Account");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(15, 25, 15, 25));
        add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Open New Account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        accIdField = new JTextField(15);
        balanceField = new JTextField(15);
        JButton createBtn = new JButton("Register Account");
        createBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        createBtn.setPreferredSize(new Dimension(0, 35));

        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));

        // UI Layout placement
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(new JLabel("Account ID (10 digits):"), gbc);
        gbc.gridx = 1;
        panel.add(accIdField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(new JLabel("Initial Deposit:"), gbc);
        gbc.gridx = 1;
        panel.add(balanceField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 5, 5, 5);
        panel.add(createBtn, gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(messageLabel, gbc);

        createBtn.addActionListener(e -> handleCreate());
        setVisible(true);
    }

    private void handleCreate() {
        String accId = accIdField.getText().trim();
        String balanceText = balanceField.getText().trim();

        // Check if ID is exactly 10 digits
        if (accId.length() != 10) {
            messageLabel.setForeground(new Color(192, 57, 43));
            messageLabel.setText("Account ID must be exactly 10 digits.");
            return;
        }

        try {
            double balance = Double.parseDouble(balanceText);
            OpenNewAccount account = new OpenNewAccount(accId, balance);
            String result = account.recordAccount();
            messageLabel.setForeground(new Color(39, 174, 96));
            messageLabel.setText(result);
        } catch (NumberFormatException ex) {
            messageLabel.setForeground(new Color(192, 57, 43));
            messageLabel.setText("Invalid deposit amount.");
        } catch (IOException ex) {
            messageLabel.setForeground(new Color(192, 57, 43));
            messageLabel.setText("Error: " + ex.getMessage());
        }
    }
}