package Book;

class Book {
    String title;
    String author;
    String isbn;

    // Constructor
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Method to display book information
    void displayBook() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("ISBN   : " + isbn);
        System.out.println();
    }

    // Method to add a book to collection
    static void addBook(Book[] collection, Book book, int index) {
        if (index >= 0 && index < collection.length) {
            collection[index] = book;
            System.out.println(book.title + " added successfully.\n");
        }
    }

    // Method to remove a book from collection
    static void removeBook(Book[] collection, String isbn) {
        boolean found = false;

        for (int i = 0; i < collection.length; i++) {
            if (collection[i] != null && collection[i].isbn.equals(isbn)) {
                System.out.println(collection[i].title + " removed successfully.\n");
                collection[i] = null;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.\n");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // Array of Book objects
        Book[] collection = new Book[5];

        // Creating Book objects
        Book b1 = new Book("Java Programming", "James Gosling", "ISBN101");
        Book b2 = new Book("Data Structures", "Mark Allen", "ISBN102");
        Book b3 = new Book("Database Systems", "Elmasri", "ISBN103");

        // Adding books
        Book.addBook(collection, b1, 0);
        Book.addBook(collection, b2, 1);
        Book.addBook(collection, b3, 2);

        // Display all books
        System.out.println("Books in Collection:");
        for (Book b : collection) {
            if (b != null) {
                b.displayBook();
            }
        }

        // Removing a book
        Book.removeBook(collection, "ISBN102");

        // Display collection after removal
        System.out.println("Books in Collection After Removal:");
        for (Book b : collection) {
            if (b != null) {
                b.displayBook();
            }
        }
    }
}
