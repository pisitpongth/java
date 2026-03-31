import java.util.Scanner;

public class InventoryMain {
    public static void showInfo(Inventory product) {
        System.out.println("Product name: " + product.getName() +
                "\nCurrent stock: " + product.getStock() +
                "\n------------------------------");
    }

    public static void main(String[] args) {
        Inventory product1 = new Inventory("Pen", 100);
        Scanner sc = new Scanner(System.in);

        boolean is_loop = false;

        showInfo(product1);

        while (!is_loop) {
            System.out.println("Press 1 to add item in stock" +
                    "\nPress 2 to remove item from stock");

            System.out.print("Enter a menu: ");
            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.print("How many item to add in stock: ");
                int amount = sc.nextInt();
                product1.addStock(amount);
                System.out.println();
                showInfo(product1);
            } else if (menu == 2) {
                System.out.print("How many item to remove from stock: ");
                int amount = sc.nextInt();
                product1.removeStock(amount);
                System.out.println();
                showInfo(product1);
            } else {
                is_loop = true;
                System.out.println("END PROGRAM");
            }
        }
    }
}
