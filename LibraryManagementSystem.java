import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private boolean available;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true; // Default: available
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// Member class
class Member {
    private String name;
    private int memberId;

    // Constructor
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
}

// Library class
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Show all books
    public void showBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor() +
                    (book.isAvailable() ? " [Available]" : " [Borrowed]"));
        }
    }

    // Borrow a book
    public void borrowBook(String title, Member member) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println(member.getName() + " borrowed \"" + book.getTitle() + "\" successfully.");
                } else {
                    System.out.println("Sorry, \"" + book.getTitle() + "\" is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return a book
    public void returnBook(String title, Member member) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println(member.getName() + " returned \"" + book.getTitle() + "\" successfully.");
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Library
        Library library = new Library();

        // Add some books (hardcoded)
        library.addBook(new Book("Java Programming", "James Gosling"));
        library.addBook(new Book("Python Basics", "Guido van Rossum"));
        library.addBook(new Book("C++ Primer", "Bjarne Stroustrup"));

        // Get member details
        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        Member member = new Member(name, id);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = sc.nextLine();
                    library.borrowBook(borrowTitle, member);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle, member);
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
