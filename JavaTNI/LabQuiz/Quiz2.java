package JavaTNI.LabQuiz;

import javax.swing.JOptionPane;

public class Quiz2 {
    public static void main(String[] args) {
        int number;

        number = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Enter an integer:",
                "Input",
                JOptionPane.QUESTION_MESSAGE));

        while (number <= 0) {
            number = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "The number must be greater than 1" +
                            "\nEnter an integer:",
                    "Input",
                    JOptionPane.QUESTION_MESSAGE));
        }

        int total = 0;
        StringBuilder expression = new StringBuilder();

        for (int i = 1; i <= number; i++) {
            total += i;
            expression.append(i);
            if (i < number) {
                expression.append(" + ");
            }
        }

        JOptionPane.showMessageDialog(null,
                "Summation between 1 to " + number +
                        "\n" + expression + " = " + total);
    }
}
