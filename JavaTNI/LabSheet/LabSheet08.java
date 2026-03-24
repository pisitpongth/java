package TNI_Lab.LabSheet;

import java.util.Scanner;

public class LabSheet08 {
    public static void main(String[] args) {
        int num1;
        int num2;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        num2 = sc.nextInt();

        sc.close();

        try {
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
