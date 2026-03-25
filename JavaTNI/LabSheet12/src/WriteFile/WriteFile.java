package WriteFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteFile {
    public static String input_user() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter birth year: ");
        String birth_year = sc.nextLine();

        return username + "," + password + "," + gender + "," + birth_year;
    }

    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("src/WriteFile/users2.txt", true);
        PrintWriter writer = new PrintWriter(file);

        writer.println(input_user());
        writer.close();
    }
}
