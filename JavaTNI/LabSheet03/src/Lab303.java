import java.util.Scanner;

public class Lab303 {
    public static void main(String[] args) {
        // Create a Scanner object for keyboard input
        Scanner input = new Scanner(System.in);

        // Input value for X coordinate
        System.out.print("Enter the value for X coordinate: ");
        int x = input.nextInt();

        // Input value for Y coordinate
        System.out.print("Enter the value for Y coordinate: ");
        int y = input.nextInt();

        String position = "";

        // Determine the position based on X and Y values
        if (x == 0 && y == 0) {
            position = "Origin";
        } else if (x > 0 && y > 0) {
            position = "First quadrant";
        } else if (x < 0 && y > 0) {
            position = "Second quadrant";
        } else if (x < 0 && y < 0) {
            position = "Third quadrant";
        } else if (x > 0 && y < 0) {
            position = "Fourth quadrant";
        } else {
            // This part handles cases where the point lies on the axis (X=0 or Y=0)
            // but not at the origin. The prompt doesn't specify this,
            // but we can label it generally.
            position = "Axis";
        }

        // Display the output in the required format
        System.out.println("The coordinate point (" + x + "," + y + ") lies in the " + position);

        input.close();
    }
}