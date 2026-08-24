import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> books = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== Library System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String book = sc.nextLine();
                    books.add(book);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeBook = sc.nextLine();

                    if (books.remove(removeBook)) {
                        System.out.println("Book removed successfully!");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("\nAvailable Books:");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i + 1) + ". " + books.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Library System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}