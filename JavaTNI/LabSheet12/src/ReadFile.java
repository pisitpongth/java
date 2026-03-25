import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static String hide_password(String password) {
        String hide_password = "";

        for (int i = 0; i < password.length(); i++) {
            if (i == 0) {
                hide_password += password.charAt(i);
            } else if (i == password.length() - 1) {
                hide_password += password.charAt(i);
            } else {
                hide_password += "*";
            }
        }
        return hide_password;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/users.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String[] data = sc.nextLine().split(",");
            String username = data[0];
            String password = data[1];
            String gender = data[2];
            int birth_year = Integer.parseInt(data[3]);

            System.out.println("Username = " + username +
                    "\nPassword = " + hide_password(password) +
                    "\nGender = " + gender +
                    "\nBirth Year = " + birth_year);
            System.out.println();
        }
        sc.close();
    }
}
