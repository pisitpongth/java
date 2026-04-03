import java.util.Scanner;

public class Lab603 {

    // 1. Method to check if an index is within array boundaries
    public static boolean check_index(int[] numbers, int index) {
        // A valid index must be >= 0 and < array length
        return (index >= 0 && index < numbers.length);
    }

    // 2. Method to handle user input for index with validation loop
    public static int input_index(int[] numbers) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index: ");
        int idx = sc.nextInt();

        // Keep asking until check_index returns true
        while (!check_index(numbers, idx)) {
            System.out.print("Invalid index!! Enter index, again: ");
            idx = sc.nextInt();
        }
        return idx;
    }

    // 3. Method to display all elements in the array
    public static void display_array(int[] numbers) {
        System.out.print("List of numbers in array: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // --- MAIN METHOD AT THE BOTTOM ---
    public static void main(String[] args) {
        // Define the array with provided values
        int[] numbers = {47, 13, 82, 17, 61, 29, 94, 36};

        // Step 1: Show the array contents
        display_array(numbers);

        // Step 2: Get the index from user (using validation method)
        int index = input_index(numbers);
        System.out.println(); // Formatting newline

        // Step 3: Show number at the current index
        System.out.println("The number at index " + index + " is " + numbers[index]);

        // Step 4: Show number BEFORE current index
        System.out.print("The number before index " + index + " is ");
        if (check_index(numbers, index - 1)) {
            System.out.println(numbers[index - 1]);
        } else {
            System.out.println("Out of range!!");
        }

        // Step 5: Show number AFTER current index
        System.out.print("The number after  index " + index + " is ");
        if (check_index(numbers, index + 1)) {
            System.out.println(numbers[index + 1]);
        } else {
            System.out.println("Out of range!!");
        }
    }
}