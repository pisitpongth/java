import javax.swing.JOptionPane;

public class Lab204 {
    public static void main(String[] args) {
        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to the payroll application", "Message", JOptionPane.INFORMATION_MESSAGE);

        // Input Employee Name and Hours Worked
        String name = JOptionPane.showInputDialog(null, "Enter employee name:", "Input", JOptionPane.QUESTION_MESSAGE);
        String hoursStr = JOptionPane.showInputDialog(null, "Enter total hour for this employee:", "Input", JOptionPane.QUESTION_MESSAGE);

        double hoursWorked = Double.parseDouble(hoursStr);
        double hourlyWage = 7.50;
        double taxRate = 0.15;

        // Calculations
        double grossEarnings = hoursWorked * hourlyWage;
        double taxAmount = grossEarnings * taxRate;
        double netEarnings = grossEarnings - taxAmount;

        // Format and display the payroll summary
        String result = "Employee name: " + name + "\n" +
                "Hour worked: " + (int) hoursWorked + "\n" +
                "Hourly wage: $" + hourlyWage + "\n" +
                "Gross earnings: $" + String.format("%.2f", grossEarnings) + "\n" +
                "Tax rate: " + taxRate + "\n" +
                "Tax: $" + String.format("%.2f", taxAmount) + "\n" +
                "Net earnings: $" + String.format("%.2f", netEarnings);

        JOptionPane.showMessageDialog(null, result, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}