import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean is_loop = false;

        while (!is_loop) {
            try {
                System.out.print("Enter a number: ");
                number = sc.nextInt();
                is_loop = true;

            } catch (InputMismatchException e) {
                System.out.print("Invalid Data!! ");
                sc.next();
            }
        }
        System.out.println();
        System.out.println("You inputted number = " + number);
    }
}
