import javax.swing.JOptionPane;

public class Lab203 {
    public static void main(String[] args) {
        // Get total minutes from user input dialog
        String input = JOptionPane.showInputDialog(null, "Input minutes:", "Input", JOptionPane.QUESTION_MESSAGE);
        int totalMinutes = Integer.parseInt(input);

        // Calculate hours and remaining minutes
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        // Display the result
        String message = totalMinutes + " minutes is " + hours + " hour " + minutes + " minute";
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}