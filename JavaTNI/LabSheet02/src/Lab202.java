import java.util.Scanner;

public class Lab202 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input hours and minutes
        System.out.print("Input hour   : ");
        int hour = input.nextInt();
        System.out.print("Input minute : ");
        int minute = input.nextInt();

        // Calculate total minutes: (hours * 60) + minutes
        int totalMinutes = (hour * 60) + minute;

        System.out.println("Total time is " + totalMinutes + " minutes");

        input.close();
    }
}