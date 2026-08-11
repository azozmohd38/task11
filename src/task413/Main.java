package task413;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Attendable> queue = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.setupInitialPatient();
        app.runMenu();
    }

    private void setupInitialPatient() {
        IO.println("--- Single item created at startup... ---");
        BookedPatient initialPatient = new BookedPatient("09:30");
        initialPatient.setName("Sarah Bennett");
        initialPatient.setAge(150); // Intentionally invalid age to test rule (prints "Invalid age")
        initialPatient.printAllInfo();
        queue.add(initialPatient);
    }

    private void runMenu() {
        boolean exit = false;
        while (!exit) {
            IO.println("\n--- CLINIC MENU ---");
            IO.println("1. Add booked  2. Add walk-in  3. Print queue  4. Longest wait  5. Exit");
            IO.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    queue.add(addBooked());
                    System.out.println("Added.");
                    break;
                case 2:
                    queue.add(addWalkIn());
                    System.out.println("Added.");
                    break;
                case 3:
                    printQueue();
                    break;
                case 4:
                    showLongestWait();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private BookedPatient addBooked() {
        System.out.print("Enter slot time: ");
        String slot = scanner.nextLine();

        BookedPatient patient = new BookedPatient(slot);

        System.out.print("Enter name: ");
        patient.setName(scanner.nextLine());

        System.out.print("Enter age: ");
        patient.setAge(scanner.nextInt());
        scanner.nextLine(); // Clear buffer

        return patient;
    }

    private WalkInVisitor addWalkIn() {
        WalkInVisitor visitor = new WalkInVisitor();

        System.out.print("Enter name: ");
        visitor.setName(scanner.nextLine());

        System.out.print("Enter age: ");
        visitor.setAge(scanner.nextInt());

        System.out.print("Enter arrival order: ");
        visitor.setArrivalOrder(scanner.nextInt());
        scanner.nextLine(); // Clear buffer

        return visitor;
    }

    private void printQueue() {
        int index = 1;
        for (Attendable person : queue) {
            System.out.print(index++ + ". ");
            person.printAllInfo();
        }
    }

    private void showLongestWait() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Attendable longestPerson = queue.get(0);
        for (Attendable person : queue) {
            if (person.getWaitMinutes() > longestPerson.getWaitMinutes()) {
                longestPerson = person;
            }
        }


        String name = (longestPerson instanceof BookedPatient)
                ? ((BookedPatient) longestPerson).getName()
                : ((WalkInVisitor) longestPerson).getName();

        IO.println("Longest wait: " + name + " (" + longestPerson.getWaitMinutes() + " min)");
    }
}
