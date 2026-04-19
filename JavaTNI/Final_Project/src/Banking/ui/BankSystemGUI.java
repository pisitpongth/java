package Banking.ui;

import Banking.ui.OpenAccountFrame;
import Banking.ui.TransactionFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

// Main window that lets the user choose what to do
public class BankSystemGUI extends JFrame {

    public BankSystemGUI() {
        setTitle("Bank System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Welcome to Bank System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton openAccountBtn = new JButton("Open New Account");
        JButton transactionBtn = new JButton("Account Transaction");

        openAccountBtn.setPreferredSize(new Dimension(200, 45));
        transactionBtn.setPreferredSize(new Dimension(200, 45));

        // Open the new account window
        openAccountBtn.addActionListener(e -> {
            new OpenAccountFrame();
        });

        // Open the transaction window
        transactionBtn.addActionListener(e -> {
            new TransactionFrame();
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);
        gbc.gridx = 0;

        gbc.gridy = 0;
        add(titleLabel, gbc);
        gbc.gridy = 1;
        add(openAccountBtn, gbc);
        gbc.gridy = 2;
        add(transactionBtn, gbc);

        setVisible(true);
    }

    // Start the app here
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankSystemGUI());
    }
}
