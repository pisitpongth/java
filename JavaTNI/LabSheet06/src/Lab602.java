import java.util.Scanner;
import java.util.Random;

public class Lab602 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Call random_array() to generate 10 random numbers
        int[] numbers = random_array();

        // 2. Receive guess input from user
        System.out.print("Enter your guess (0-20): ");
        int guess_number = sc.nextInt();
        System.out.println(); // Add a newline for spacing

        // 3. Check the count of the guessed number in the array
        int count = count_element(numbers, guess_number);

        if (count > 0) {
            // Case: Number found
            System.out.println("Congratulations!! " + guess_number + " is an element in the array!!");

            // If it appears more than once
            if (count > 1) {
                System.out.println("Fantastic!! It also appears more than once!!");
            }
        } else {
            // Case: Number not found
            System.out.println("Sorry, try again next time...");
            display_array(numbers); // Reveal the elements
        }

        sc.close();
    }

    // Method to create an array with 10 random numbers (0-20)
    public static int[] random_array() {
        Random random = new Random();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(21); // Random integers from 0 to 20
        }
        return nums;
    }

    // Method to display all elements in the array
    public static void display_array(int[] numbers) {
        System.out.print("Here are the elements in the array: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Method to count how many times 'element' appears in 'numbers' array
    public static int count_element(int[] numbers, int element) {
        int count = 0;
        for (int n : numbers) {
            if (n == element) {
                count++;
            }
        }
        return count;
    }
}