package task412;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private List<Sellable> stock = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        main app = new main();
        app.setupInitialProduct();
        app.runMenu();
    }

    private void setupInitialProduct() {
        IO.println("--- Single item created at startup ---");
        Product initialProduct = new Product("Rice 5kg", -5, 12);
        initialProduct.printAllInfo();
        stock.add(initialProduct);
    }

    private void runMenu() {
        boolean exit = false;
        while (!exit) {
            IO.println("\n--- SHOP MENU ---");
            IO.println("1. Add product  2. Add service  3. Print stock  4. Total value  5. Exit");
            IO.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    stock.add(addProduct());
                    IO.println("Added.");
                    break;
                case 2:
                    stock.add(addService());
                   IO.println("Added.");
                    break;
                case 3:
                    printStock();
                    break;
                case 4:
                    showTotalValue();
                    break;
                case 5:
                    exit = true;
                    IO.println("Goodbye.");
                    break;
                default:
                   IO.println("Invalid choice.");
            }
        }
    }

    private Product addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        return new Product(name, price, quantity);
    }

    private Service addService() {
        System.out.print("Enter service name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        return new Service(name, price, minutes);
    }

    private void printStock() {
        int index = 1;
        for (Sellable item : stock) {
            System.out.print(index++ + ". ");
            item.printAllInfo();
        }
    }

    private void showTotalValue() {
        double totalValue = 0.0;
        for (Sellable item : stock) {
            totalValue += item.getPrice();
        }
        System.out.printf("Total value of stock: %.2f OMR\n", totalValue);
    }
}
