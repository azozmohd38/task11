package task414;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private List<Rentable> rentals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.setupInitialData();
        app.runMenu();
    }

    private void setupInitialData() {
        IO.println("--- Single item created at startup ---");

        Car initialCar = new Car("", 25.0, 5, 2022); // Empty plate tests validation
        initialCar.printAllInfo();
        rentals.add(initialCar);
    }

    private void runMenu() {
        boolean exit = false;
        while (!exit) {
            IO.println("\n--- VEHICLE RENTAL DESK MENU ---");
            IO.println("1. Add a car");
            IO.println("2. Add a motorbike");
            IO.println("3. Print everything on hire");
            IO.println("4. Show total income");
            IO.println("5. Exit");
            IO.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    rentals.add(addCar());
                    System.out.println("Car added successfully.");
                    break;
                case 2:
                    rentals.add(addMotorbike());
                    System.out.println("Motorbike added successfully.");
                    break;
                case 3:
                    printAllRentals();
                    break;
                case 4:
                    calculateTotalIncome();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu choice.");
            }
        }
    }

    private Car addCar() {
        System.out.print("Enter plate number: ");
        String plate = scanner.nextLine();
        System.out.print("Enter daily rate (OMR): ");
        double rate = scanner.nextDouble();
        System.out.print("Enter number of seats: ");
        int seats = scanner.nextInt();
        System.out.print("Enter model year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        return new Car(plate, rate, seats, year);
    }

    private Motorbike addMotorbike() {
        System.out.print("Enter plate number: ");
        String plate = scanner.nextLine();
        System.out.print("Enter daily rate (OMR): ");
        double rate = scanner.nextDouble();
        System.out.print("Enter engine size (cc): ");
        int engine = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();

        return new Motorbike(plate, rate, engine, vin);
    }

    private void printAllRentals() {
        if (rentals.isEmpty()) {
            System.out.println("No vehicles currently on hire.");
            return;
        }
        IO.println("\n--- Current Vehicles on Hire ---");
        for (Rentable vehicle : rentals) {
            vehicle.printAllInfo();
        }
    }

    private void calculateTotalIncome() {
        System.out.print("Enter duration of rental in days (1-30): ");
        int days = scanner.nextInt();

        if (days < 1 || days > 30) {
            IO.println("Rental days must be from 1 to 30.");
            return;
        }

        double totalIncome = 0;
        for (Rentable vehicle : rentals) {

            totalIncome += vehicle.costFor(days);
        }
        System.out.printf("Total anticipated income for %d days: %.3f OMR\n", days, totalIncome);
    }
}
