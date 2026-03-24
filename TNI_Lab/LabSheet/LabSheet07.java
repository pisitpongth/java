package TNI_Lab.LabSheet;

import javax.swing.JOptionPane;

public class LabSheet07 {
    public static boolean is_prime_number(int number) {
        if (number <= 1)
            return false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int number;

        do {
            number = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter an integer:"));

        } while (number <= 1);

        if (is_prime_number(number)) {
            JOptionPane.showMessageDialog(
                    null,
                    number + " is Prime number");
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    number + " is NOT Prime number");
        }
    }
}
