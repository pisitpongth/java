package TNI_Lab.LabSheet;

import java.util.Scanner;

public class LabSheet06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        int count = 0;

        while (count < 5) {
            System.out.print("Enter number " + (count + 1) + ": ");
            int input = scanner.nextInt();

            while (input <= 0) {
                System.out.print("The number must be positive! Enter number again: ");
                input = scanner.nextInt();
            }

            numbers[count] = input;
            count++;
        }

        System.out.print("List of even number: ");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }

        System.out.println();

        System.out.print("List of odd number: ");
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }

        System.out.println();
        scanner.close();
    }
}
