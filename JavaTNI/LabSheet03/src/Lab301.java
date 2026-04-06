import java.util.Scanner;

public class Lab301 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter an integer number: ");
        int number = scanner.nextInt();

        // Logic to determine if the number is Zero, Positive/Negative, and Even/Odd
        if (number == 0) {
            // Case for Zero
            System.out.println("This is Zero number.");
        } else {
            String parity; // To store "Even" or "Odd"
            String sign;   // To store "Positive" or "Negative"

            // Check if the number is Even or Odd using the modulo operator (%)
            if (number % 2 == 0) {
                parity = "Even";
            } else {
                parity = "Odd";
            }

            // Check if the number is Positive or Negative
            if (number > 0) {
                sign = "Positive";
            } else {
                sign = "Negative";
            }

            // Display the final result formatted as requested
            System.out.println("This number is " + parity + " and " + sign + " number.");
        }

        // Close the scanner resource
        scanner.close();
    }
}