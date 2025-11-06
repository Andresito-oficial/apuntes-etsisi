import java.util.List;
import java.util.ArrayList;

public class Library {

    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public void addBook(String title, int year, String author) {
        final Book book = new Book(title, year, author);
        if (books.contains(book)) {
            System.out.println("Book already exists");
            return;
        }
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Biblioteca:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.titleStartsWith(title)) {
                System.out.println(book);
            }
        }
    }

}