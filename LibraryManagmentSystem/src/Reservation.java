public class Reservation {
    private Patron patron;
    private Book book;

    public Reservation(Patron patron, Book book) {
        this.patron = patron;
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public Book getBook() {
        return book;
    }
}
