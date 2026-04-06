import javax.swing.JOptionPane;

public class Lab302 {
    public static void main(String[] args) {
        // Step 1: Input Name
        String name = JOptionPane.showInputDialog(null, "Enter your name:", "Input", JOptionPane.QUESTION_MESSAGE);

        // Step 2: Input Height
        String heightStr = JOptionPane.showInputDialog(null, "Enter your height (cm.):", "Input", JOptionPane.QUESTION_MESSAGE);
        double height = Double.parseDouble(heightStr);

        // Step 3: Ask if Male
        int isMale = JOptionPane.showConfirmDialog(null, "Are your biological gender is Male?", "Gender", JOptionPane.YES_NO_OPTION);

        if (isMale == JOptionPane.YES_OPTION) {
            // Formula for Male: Height - 100
            double weight = height - 100;
            String message = "Hello, Mr." + name + "\n" +
                    "If your height is " + height + " cm.\n" +
                    "Your weight should be " + weight + " kg.";
            JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);

        } else {
            // Step 4: Ask for Female gender if the previous answer was "No"
            int isFemale = JOptionPane.showConfirmDialog(null, "Are your biological gender is Female?", "Gender", JOptionPane.YES_NO_OPTION);

            if (isFemale == JOptionPane.YES_OPTION) {
                // Formula for Female: Height - 110
                double weight = height - 110;
                String message = "Hello, Ms." + name + "\n" +
                        "If your height is " + height + " cm.\n" +
                        "Your weight should be " + weight + " kg.";
                JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Step 5: Final message if both are "No"
                JOptionPane.showMessageDialog(null, "You can use BMI to measure your weight and height.", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}