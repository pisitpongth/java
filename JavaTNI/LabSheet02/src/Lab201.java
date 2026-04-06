import java.util.Scanner;

public class Lab201 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get two double numbers from the user
        System.out.print("Enter number 1: ");
        double num1 = input.nextDouble();
        System.out.print("Enter number 2: ");
        double num2 = input.nextDouble();

        // Perform arithmetic operations
        System.out.println("\nSummation = " + (num1 + num2));
        System.out.println("Subtraction = " + (num1 - num2));
        System.out.println("Multiplication = " + (num1 * num2));
        System.out.println("Division = " + (num1 / num2));
        System.out.println("Modulus = " + (num1 % num2));

        input.close();
    }
}