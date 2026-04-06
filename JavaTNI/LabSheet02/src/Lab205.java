import javax.swing.JOptionPane;

public class Lab205 {
    public static void main(String[] args) {
        // Input Start Time
        int startH = Integer.parseInt(JOptionPane.showInputDialog("Input start time (hour):"));
        int startM = Integer.parseInt(JOptionPane.showInputDialog("Input start time (minute):"));

        // Input End Time
        int endH = Integer.parseInt(JOptionPane.showInputDialog("Input end time (hour):"));
        int endM = Integer.parseInt(JOptionPane.showInputDialog("Input end time (minute):"));

        // Convert everything to total minutes to find the difference
        int startTotal = (startH * 60) + startM;
        int endTotal = (endH * 60) + endM;
        int diffMinutes = endTotal - startTotal;

        // Convert difference back to Hours and Minutes for display
        int durationH = diffMinutes / 60;
        int durationM = diffMinutes % 60;

        // Calculate Payment: Hours * 50 + Minutes * 0.25
        double payment = (durationH * 50.0) + (durationM * 0.25);

        // Display Result Summary
        String result = "Start parking at " + startH + ":" + startM + "\n" +
                "End parking at " + endH + ":" + endM + "\n" +
                "Total time is " + durationH + " hour " + durationM + " minutes\n" +
                "Parking payment is " + String.format("%.2f", payment) + " baht.";

        JOptionPane.showMessageDialog(null, result, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}