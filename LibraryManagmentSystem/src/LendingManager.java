import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LendingManager {
    private LibrarySystem librarySystem;
    private Map<Integer, List<Reservation>> bookReservations;

    public LendingManager(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.bookReservations = new HashMap<>();
    }

    public void checkoutBook(int bookId, int patronId, int branchId) {
        Branch branch = librarySystem.getBranchById(branchId);
        if (branch == null) {
            System.out.println("Branch not found.");
            return;
        }
        Book book = branch.getInventoryManager().getAllBooks().stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
        Patron patron = librarySystem.getPatronById(patronId);

        if (book != null && book.isAvailable() && patron != null) {
            book.setAvailable(false);
            book.setQuantity(-1);
            patron.addToBorrowingHistory(book);
            System.out.println("Book " + book.getTitle() + " checked out to " + patron.getName() + " from branch " + branch.getName());
        } else {
            System.out.println("Book or patron not found, or book not available.");
        }
    }

    public void returnBook(int bookId, int patronId, int branchId) {
        Branch branch = librarySystem.getBranchById(branchId);
        if (branch == null) {
            System.out.println("Branch not found.");
            return;
        }
        Book book = branch.getInventoryManager().getAllBooks().stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
        Patron patron = librarySystem.getPatronById(patronId);

        if (book != null && !book.isAvailable() && patron != null) {
            book.setAvailable(true);
            book.setQuantity(1);
            patron.removeFromBorrowingHistory(book);
            System.out.println("Book " + book.getTitle() + " returned by " + patron.getName() + " to branch " + branch.getName());
            notifyPatron(bookId, branchId);
        } else {
            System.out.println("Book or patron not found, or book already returned.");
        }
    }

    public boolean isBookAvailable(int bookId, int branchId) {
        Branch branch = librarySystem.getBranchById(branchId);
        if (branch == null) {
            System.out.println("Branch not found.");
            return false;
        }
        Book book = branch.getInventoryManager().getAllBooks().stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
        return book != null && book.isAvailable();
    }

    public void reserveBook(int bookId, int patronId, int branchId) {
        Branch branch = librarySystem.getBranchById(branchId);
        if (branch == null) {
            System.out.println("Branch not found.");
            return;
        }
        Book book = branch.getInventoryManager().getAllBooks().stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
        Patron patron = librarySystem.getPatronById(patronId);

        if (book != null && patron != null) {
            Reservation reservation = new Reservation(patron, book);
            bookReservations.computeIfAbsent(bookId, k -> new ArrayList<>()).add(reservation);
            System.out.println("Book " + book.getTitle() + " reserved by " + patron.getName() + " at branch " + branch.getName());
        } else {
            System.out.println("Book or patron not found.");
        }
    }

    public void notifyPatron(int bookId, int branchId) {
        Branch branch = librarySystem.getBranchById(branchId);
        if (branch == null) {
            System.out.println("Branch not found.");
            return;
        }
        Book book = branch.getInventoryManager().getAllBooks().stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
        if (book != null) {
            List<Reservation> reservations = bookReservations.get(bookId);
            if (reservations != null && !reservations.isEmpty()) {
                Reservation nextReservation = reservations.remove(0);
                System.out.println("Notifying patron " + nextReservation.getPatron().getName() + " that book " + book.getTitle() + " is available at branch " + branch.getName());
            }
        }
    }
}