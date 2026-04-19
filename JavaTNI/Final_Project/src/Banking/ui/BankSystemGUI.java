package Banking.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BankSystemGUI extends JFrame {

    // Store variables to track window status and prevent multiple windows
    private OpenAccountFrame openAccountFrame = null;
    private TransactionFrame transactionFrame = null;

    public BankSystemGUI() {
        setTitle("Bank Management System");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel with Padding
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 245, 245));
        add(mainPanel);

        JLabel titleLabel = new JLabel("Banking System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(44, 62, 80));

        JButton openAccountBtn = new JButton("Open New Account");
        JButton transactionBtn = new JButton("Account Transaction");

        // Style the buttons
        Dimension btnSize = new Dimension(250, 50);
        configureButton(openAccountBtn, btnSize);
        configureButton(transactionBtn, btnSize);

        // Action listeners to prevent opening duplicate windows
        openAccountBtn.addActionListener(e -> {
            if (openAccountFrame == null || !openAccountFrame.isDisplayable()) {
                openAccountFrame = new OpenAccountFrame();
            } else {
                openAccountFrame.toFront();
                openAccountFrame.setState(Frame.NORMAL);
            }
        });

        transactionBtn.addActionListener(e -> {
            if (transactionFrame == null || !transactionFrame.isDisplayable()) {
                transactionFrame = new TransactionFrame();
            } else {
                transactionFrame.toFront();
                transactionFrame.setState(Frame.NORMAL);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);
        gbc.gridy = 1;
        mainPanel.add(openAccountBtn, gbc);
        gbc.gridy = 2;
        mainPanel.add(transactionBtn, gbc);

        setVisible(true);
    }

    private void configureButton(JButton button, Dimension size) {
        button.setPreferredSize(size);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setBackground(Color.WHITE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(BankSystemGUI::new);
    }
}