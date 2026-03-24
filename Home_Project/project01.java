package Home_Project;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class project01 {
    public static void main(String[] args) {
        double firstNumber = 0, secondNumber = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input1 = JOptionPane.showInputDialog("Input first number:");

                if (input1 == null) {
                    JOptionPane.showMessageDialog(null, "Error, Closed program");
                    return;
                }
                firstNumber = Double.parseDouble(input1);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter number only!");
            }
        }
        String operation = JOptionPane.showInputDialog("Enter operation (+, -, *, /):");

        if (operation == null) {
            JOptionPane.showMessageDialog(null, "Error, Closed program");
            return;
        }
        validInput = false;
        while (!validInput) {
            try {
                String input2 = JOptionPane.showInputDialog("Input second number:");

                if (input2 == null) {
                    JOptionPane.showMessageDialog(null, "Error, Closed program");
                    return;
                }
                secondNumber = Double.parseDouble(input2);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter number only!");
            }
        }
        double result;

        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    JOptionPane.showMessageDialog(null, "Can not divided by Zero!");
                    return;
                }
                result = firstNumber / secondNumber;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Wrong operation");
                return;
        }
        DecimalFormat df = new DecimalFormat("#,###.00");

        JOptionPane.showMessageDialog(null,
                firstNumber + " " + operation + " " + secondNumber + " = " + df.format(result));
    }
}
