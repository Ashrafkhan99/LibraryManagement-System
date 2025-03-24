public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private int bookId;
    private boolean isAvailable;
    private int quantity;

    public Book(String title, String author, String isbn, int publicationYear, int bookId, int q) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.bookId = bookId;
        this.isAvailable = true; // initially available
        this.quantity = q;
    }

    // Getters and Setters...
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
    public int getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", bookId=" + bookId +
                ", isAvailable=" + isAvailable +
                '}';
    }
}