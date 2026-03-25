import javax.swing.*;

public class Exception102 {
    public static void main(String[] args) {
        int number = 0;
        boolean is_loop = false;

        while (!is_loop) {
            try {
                number = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer: "));
                is_loop = true;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: " + e.getMessage(),
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, "You inputted number = " + number);
    }
}
