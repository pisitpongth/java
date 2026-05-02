import java.util.Scanner;

public class CakeOrder2 {
    public static boolean addSprinkles() {
        Scanner sc = new Scanner(System.in);

        boolean isAddSprinkles = false;

        System.out.print("Do you want to add Sprinkles [y/Y]? ");
        String choice = sc.nextLine();

        boolean isDone = false;

        while (!isDone) {
            if (choice.equals("y") || choice.equals("Y")) {
                isAddSprinkles = true;
                isDone = true;
            } else {
                System.out.print("Failed!! Try again: ");
                choice = sc.nextLine();
            }
        }
        return isAddSprinkles;
    }

    public static String selectFlavor() {
        boolean isDone = false;
        String flavor = "";

        System.out.println("Press 1 for Chocolate" +
                "\nPress 2 for Vanilla" +
                "\nPress 3 for Strawberry" +
                "\nPress 4 for Lemon" +
                "\nPress 5 for Red Velvet");

        Scanner sc = new Scanner(System.in);

        while (!isDone) {
            System.out.print("Enter a flavor number: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                flavor = "Chocolate";
                isDone = true;
            } else if (choice.equals("2")) {
                flavor = "Vanilla";
                isDone = true;
            } else if (choice.equals("3")) {
                flavor = "Strawberry";
                isDone = true;
            } else if (choice.equals("4")) {
                flavor = "Lemon";
                isDone = true;
            } else if (choice.equals("5")) {
                flavor = "Red Velvet";
                isDone = true;
            }
        }
        return flavor;
    }

    public static void main(String[] args) {
        System.out.println("Press 1 to order Birthday Cake" +
                "\nPress 2 to order Cup Cake" +
                "\nPress 3 to order Donuts");

        Scanner sc = new Scanner(System.in);

        String option;
        boolean isDone = false;
        String flavor = "";

        while (!isDone) {
            System.out.print("Enter an option: ");
            option = sc.nextLine();

            if (option.equals("1")) {
                System.out.println();

                flavor = selectFlavor();

                System.out.println();

                String message;
                double pound;

                System.out.print("Enter a message: ");
                message = sc.nextLine();

                System.out.print("How many pounds: ");
                pound = Double.parseDouble(sc.nextLine());

                BirthdayCake order = new BirthdayCake(message, pound, flavor, 350);

                System.out.println();

                System.out.println(order.toString());

                isDone = true;
            } else if (option.equals("2")) {
                System.out.println();

                flavor = selectFlavor();

                System.out.println();

                int piece;

                System.out.print("How many pieces: ");
                piece = Integer.parseInt(sc.nextLine());

                CupCake order = new CupCake(piece, flavor, 70);

                System.out.println();

                System.out.println(order.toString());

                isDone = true;
            } else if (option.equals("3")) {
                System.out.println();

                flavor = selectFlavor();

                System.out.println();

                int piece;

                System.out.print("How many pieces: ");
                piece = Integer.parseInt(sc.nextLine());

                boolean isAddSprinkles;

                System.out.println();

                isAddSprinkles = addSprinkles();

                Donuts order = new Donuts(isAddSprinkles, piece, flavor, 50);

                System.out.println();

                System.out.println(order.toString());

                isDone = true;
            } else {
                System.out.println();
                System.out.println("Wrong option!! Try again!!");
                isDone = true;
            }
        }
    }
}
