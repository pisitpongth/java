package TNI_Lab.LabSheet;

import javax.swing.JOptionPane;

public class LabSheet02 {
    public static void main(String[] args) {
        final String USERNAME = "admin";
        final String PASSWORD = "Admin1234";
        boolean loginSuccess = false;

        while (!loginSuccess) {
            String inputUser = JOptionPane.showInputDialog("Enter username:");
            String inputPass = JOptionPane.showInputDialog("Enter password:");

            if (inputUser != null
                    && inputPass != null
                    && inputUser.equalsIgnoreCase(USERNAME)
                    && inputPass.equals(PASSWORD)) {
                JOptionPane.showMessageDialog(null,
                        "Login Success!!",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                loginSuccess = true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Login Fail...",
                        "Incorrect username or password",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
