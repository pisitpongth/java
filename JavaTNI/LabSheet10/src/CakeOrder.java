import java.util.Scanner;

public class CakeOrder {
    public static void main(String[] args) {
        double total = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Birthday Cake's Details:");

        System.out.print("Enter a message on cake: ");
        String message = sc.nextLine();

        System.out.print("Enter a flavor: ");
        String birthdayCakeFlavor = sc.nextLine();

        System.out.print("How many pound: ");
        double pound = Double.parseDouble(sc.nextLine());

        BirthdayCake order1 = new BirthdayCake(message, pound, birthdayCakeFlavor, 350);

        total += order1.calculateTotalPrice();

        System.out.println(order1.toString());

        System.out.println();

        System.out.println("Cup Cake's Details:");

        System.out.print("Enter a flavor: ");
        String cupcakeFlavor = sc.nextLine();

        System.out.print("How many piece: ");
        int cupcakePiece = Integer.parseInt(sc.nextLine());

        CupCake order2 = new CupCake(cupcakePiece, cupcakeFlavor, 65);

        total += order2.calculateTotalPrice();

        System.out.println(order2.toString());

        System.out.println();

        System.out.println("Donuts's Details:");

        System.out.print("Enter a flavor: ");
        String donutsFlavor = sc.nextLine();

        System.out.print("How many piece: ");
        int donutsPiece = Integer.parseInt(sc.nextLine());

        System.out.print("Do you want to add Sprinkles [y/Y]? ");
        String choice = sc.nextLine();

        boolean isAddSprinkles;

        if (choice.equals("y") || choice.equals("Y")) {
            isAddSprinkles = true;
        } else {
            isAddSprinkles = false;
        }

        Donuts order3 = new Donuts(isAddSprinkles, donutsPiece, donutsFlavor, 50);

        total += order3.calculateTotalPrice();

        System.out.println(order3.toString());

        System.out.println();

        System.out.println("Total price = " + total);
    }
}
