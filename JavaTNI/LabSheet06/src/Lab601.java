import java.util.Scanner;

public class Lab601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        // Loop to get 5 positive integer inputs
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int input = sc.nextInt();

            // Validation loop: ensures the input is a positive integer (> 0)
            while (input <= 0) {
                System.out.print("The number must be positive! Enter number again: ");
                input = sc.nextInt();
            }
            numbers[i] = input;
        }

        // Display the list of even numbers
        System.out.print("\nList of even number: ");
        for (int n : numbers) {
            if (n % 2 == 0) { // Check if number is divisible by 2
                System.out.print(n + " ");
            }
        }

        // Display the list of odd numbers
        System.out.print("\nList of odd  number: ");
        for (int n : numbers) {
            if (n % 2 != 0) { // Check if number has a remainder when divided by 2
                System.out.print(n + " ");
            }
        }

        System.out.println(); // Print a newline at the end
        sc.close();
    }
}