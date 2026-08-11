package task415;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Payable> members = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.setupInitialMember();
        app.runMenu();
    }

    private void setupInitialMember() {
        System.out.println("--- Single item created at startup ---");
        MonthlyMember initialMember = new MonthlyMember(101, "Ahmad Al-Busaidi", 12, 35.0); // Age 12 triggers "Too young to register."
        initialMember.printAllInfo();
        members.add(initialMember);
    }

    private void runMenu() {
        boolean exit = false;
        while (!exit) {
            IO.println("\n--- GYM MEMBERSHIP DESK MENU ---");
            IO.println("1. Add a monthly member");
            IO.println("2. Add a day-pass visitor");
            IO.println("3. Print all members");
            IO.println("4. Show total monthly income");
            IO.println("5. Search a member by name");
            IO.println("6. Exit");
            IO.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear scanner buffer

            switch (choice) {
                case 1:
                    members.add(addMonthlyMember());
                    IO.println("Monthly member added.");
                    break;
                case 2:
                    members.add(addDayPassVisitor());
                    IO.println("Day-pass visitor added.");
                    break;
                case 3:
                    printAllMembers();
                    break;
                case 4:
                    showTotalMonthlyIncome();
                    break;
                case 5:
                    searchMemberByName();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private MonthlyMember addMonthlyMember() {
        System.out.print("Enter Membership ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Monthly Fee (OMR): ");
        double fee = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        return new MonthlyMember(id, name, age, fee);
    }

    private DayPassVisitor addDayPassVisitor() {
        System.out.print("Enter Membership ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Price per Visit (OMR): ");
        double price = scanner.nextDouble();

        System.out.print("Enter Number of Visits (1-31): ");
        int visits = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        return new DayPassVisitor(id, name, age, price, visits);
    }

    private void printAllMembers() {
        if (members.isEmpty()) {
            IO.println("No members registered.");
            return;
        }
        IO.println("\n--- All Registered Members ---");
        int count = 1;
        for (Payable member : members) {
            System.out.print(count++ + ". ");
            member.printAllInfo();
        }
    }

    private void showTotalMonthlyIncome() {
        double totalIncome = 0.0;
        for (Payable member : members) {

            totalIncome += member.monthlyTotal();
        }
        System.out.printf("Total anticipated monthly income: %.3f OMR\n", totalIncome);
    }

    private void searchMemberByName() {
        IO.print("Enter name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;
        for (Payable member : members) {

            if (member.getMemberName().equalsIgnoreCase(searchName)) {
               IO.print("Member Found -> ");
                member.printAllInfo();
                found = true;
            }
        }

        if (!found) {
            IO.println("No member found matching name: " + searchName);
        }
    }
}
