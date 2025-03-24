import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManager {
    private List<Book> books;

    public InventoryManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        // Check if a book with the same ID already exists
        Book existingBook = books.stream()
                .filter(b -> b.getBookId() == book.getBookId())
                .findFirst()
                .orElse(null);

        if (existingBook != null) {
            // If the book exists, increase the quantity
            existingBook.setQuantity(book.getQuantity());
        } else {
            // If the book doesn't exist, add it to the list
            books.add(book);
        }
    }

    public void removeBook(int bookId) {
        // Find the book by ID
        Book bookToRemove = books.stream()
                .filter(b -> b.getBookId() == bookId)
                .findFirst()
                .orElse(null);

        if (bookToRemove != null) {
            // If the book exists and quantity is more than 1, decrease the quantity
            if (bookToRemove.getQuantity() > 1) {
                bookToRemove.setQuantity(-1); // Decrease quantity by 1
            } else {
                // If the quantity is 1 or less, remove the book entirely
                books.remove(bookToRemove);
            }
        }
    }

    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == book.getBookId()) {
                books.set(i, book);
                return;
            }
        }
    }

    public List<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> findBookByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Book findBookByISBN(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
