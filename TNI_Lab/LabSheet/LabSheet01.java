package TNI_Lab.LabSheet;

import javax.swing.JOptionPane;

public class LabSheet01 {
    public static void main(String[] args) {
        boolean valid = false;

        while (!valid) {
            String fullName = JOptionPane.showInputDialog("Enter your full name:");

            if (fullName != null) {
                String[] parts = fullName.trim().split(" ");

                if (parts.length >= 2) {
                    String firstName = parts[0];
                    StringBuilder lastName = new StringBuilder();

                    for (int i = 1; i < parts.length; i++) {
                        lastName.append(parts[i].toUpperCase()).append(" ");
                    }
                    String formattedFirstName = firstName.substring(0, 1).toUpperCase()
                            + firstName.substring(1).toLowerCase();
                    JOptionPane.showMessageDialog(null,
                            "Welcome, " + formattedFirstName + " " + lastName.toString().trim());
                    valid = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Invalid format. Please enter [First Name][Space][Last Name].");
                }
            }
        }
    }
}
