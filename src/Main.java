import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== Library Information System =====");
            System.out.println("1. Add a Book");
            System.out.println("2. List All Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Search a Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:
                    System.out.print("Enter Book Title to Borrow: ");
                    title = sc.nextLine();
                    library.borrowBook(title);
                    break;

                case 4:
                    System.out.print("Enter Book Title to Return: ");
                    title = sc.nextLine();
                    library.returnBook(title);
                    break;

                case 5:
                    System.out.print("Enter Book Title to Search: ");
                    title = sc.nextLine();
                    library.searchBook(title);
                    break;

                case 0:
                    System.out.println("Thank you for using the Library Information System!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
