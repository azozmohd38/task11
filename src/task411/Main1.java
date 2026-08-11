package task411;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Main1 {
        private List<LibraryItem1> catalogue = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            Main1 app = new Main1();
            app.setupInitialItem();
            app.runMenu();
        }

        private void setupInitialItem() {
            IO.println("Single item created at startup");
            Book firstBook = new Book();
            firstBook.setTitle("Clean Code");
            firstBook.setAuthor("Robert Martin");
            firstBook.setPages(464);

            firstBook.printAllInfo();
            catalogue.add(firstBook);
        }

        private void runMenu() {
            boolean exit = false;
            while (!exit) {
                IO.println("\n--- LIBRARY MENU ---");
                IO.println("1. Add book  2. Add magazine  3. Print all  4. Count  5. Exit");
                IO.print("Choose: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline character from buffer

                switch (choice) {
                    case 1:
                        catalogue.add(addBook());
                        IO.println("Added.");
                        break;
                    case 2:
                        catalogue.add(addMagazine());
                        IO.println("Added.");
                        break;
                    case 3:
                        printAllItems();
                        break;
                    case 4:
                        IO.println("Total items in catalogue: " + catalogue.size());
                        break;
                    case 5:
                        exit = true;
                        IO.println("Goodbye.");
                        break;
                    default:
                        IO.println("Invalid option.");
                }
            }
        }

        private Book addBook() {
            Book book = new Book();

            System.out.print("Enter title: ");
            book.setTitle(scanner.nextLine());

            System.out.print("Enter author: ");
            book.setAuthor(scanner.nextLine());

            System.out.print("Enter pages: ");
            book.setPages(scanner.nextInt());
            scanner.nextLine(); // Clear buffer

            return book;
        }

        private Magazine addMagazine() {
            Magazine magazine = new Magazine();

            System.out.print("Enter name: ");
            magazine.setName(scanner.nextLine());

            System.out.print("Enter issue number: ");
            magazine.setIssueNumber(scanner.nextInt());
            scanner.nextLine(); // Clear buffer

            System.out.print("Enter month: ");
            magazine.setMonth(scanner.nextLine());

            return magazine;
        }

        private void printAllItems() {
            int index = 1;
            for (LibraryItem1 item : catalogue) {
                System.out.print(index++ + ". ");
                item.printAllInfo();
            }
        }
    }



