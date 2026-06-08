package Book;

class Book {
    String title;
    String author;
    String isbn;

 
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }


    void displayBook() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("ISBN   : " + isbn);
        System.out.println();
    }

    static void addBook(Book[] collection, Book book, int index) {
        if (index >= 0 && index < collection.length) {
            collection[index] = book;
            System.out.println(book.title + " added successfully.\n");
        }
    }

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

 
        Book[] collection = new Book[5];

        Book b1 = new Book("Java Programming", "James Gosling", "ISBN101");
        Book b2 = new Book("Data Structures", "Mark Allen", "ISBN102");
        Book b3 = new Book("Database Systems", "Elmasri", "ISBN103");

        Book.addBook(collection, b1, 0);
        Book.addBook(collection, b2, 1);
        Book.addBook(collection, b3, 2);

        System.out.println("Books in Collection:");
        for (Book b : collection) {
            if (b != null) {
                b.displayBook();
            }
        }

        Book.removeBook(collection, "ISBN102");

        System.out.println("Books in Collection After Removal:");
        for (Book b : collection) {
            if (b != null) {
                b.displayBook();
            }
        }
    }
}
