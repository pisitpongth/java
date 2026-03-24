package TNI_Lab.LabQuiz;

import java.util.Scanner;

public class Quiz1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = sc.nextInt();

        int[] list_for_number1 = new int[5];
        int[] list_for_number2 = new int[5];

        list_for_number1[0] = number1;
        list_for_number1[1] = number1 * 2;
        list_for_number1[2] = number1 * 3;
        list_for_number1[3] = number1 * 4;
        list_for_number1[4] = number1 * 5;

        list_for_number2[0] = number2;
        list_for_number2[1] = number2 * 2;
        list_for_number2[2] = number2 * 3;
        list_for_number2[3] = number2 * 4;
        list_for_number2[4] = number2 * 5;

        System.out.println();
        System.out.println("Multiples of " +
                number1 +
                " = " +
                number1 +
                " " +
                list_for_number1[1] +
                " " +
                list_for_number1[2] +
                " " +
                list_for_number1[3] +
                " " +
                list_for_number1[4] +
                " ...");
        System.out.println("Multiples of " +
                number2 +
                " = " +
                number2 +
                " " +
                list_for_number2[1] +
                " " +
                list_for_number2[2] +
                " " +
                list_for_number2[3] +
                " " +
                list_for_number2[4] +
                " ...");
        System.out.println();

        int lcm = 0;

        // ====================================================================================================
        // FIND LEAST COMMON MULTIPLE USING FOR LOOP
        // ====================================================================================================
        for (int k : list_for_number1) {
            if ((k % number1 == 0) && (k % number2 == 0)) {
                lcm = k;
                break;
            }

            for (int i : list_for_number2) {
                if ((i % number1 == 0) && (i % number2 == 0)) {
                    lcm = i;
                    break;
                }
            }
        }

        System.out.println("Least Common Multiple = " + lcm);
        sc.close();
    }
}
