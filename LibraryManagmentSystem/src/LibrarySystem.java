import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Branch> branches;
    private PatronManager patronManager;
    private LendingManager lendingManager;

    public LibrarySystem() {
        this.branches = new ArrayList<>();
        this.patronManager = new PatronManager();
        this.lendingManager = new LendingManager(this);
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public void removeBranch(int branchId) {
        branches.removeIf(branch -> branch.getBranchId() == branchId);
    }

    public Branch getBranchById(int branchId) {
        return branches.stream()
                .filter(branch -> branch.getBranchId() == branchId)
                .findFirst()
                .orElse(null);
    }

    public void transferBook(int bookId, int fromBranchId, int toBranchId) {
        Branch fromBranch = getBranchById(fromBranchId);
        Branch toBranch = getBranchById(toBranchId);

        if (fromBranch != null && toBranch != null) {
            Book bookToTransfer = fromBranch.getInventoryManager().getAllBooks().stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
            if (bookToTransfer != null) {
                fromBranch.getInventoryManager().removeBook(bookId);
                toBranch.getInventoryManager().addBook(bookToTransfer);
                System.out.println("Book " + bookToTransfer.getTitle() + " transferred from " + fromBranch.getName() + " to " + toBranch.getName());
            } else {
                System.out.println("Book not found in branch " + fromBranch.getName());
            }
        } else {
            System.out.println("One or both branches not found.");
        }
    }

    // Patron Management
    public void addPatron(Patron patron) {
        patronManager.addPatron(patron);
    }

    public void updatePatron(Patron patron) {
        patronManager.updatePatron(patron);
    }

    public void removePatron(int patronId) {
        patronManager.removePatron(patronId);
    }

    public Patron getPatronById(int patronId) {
        return patronManager.getPatronById(patronId);
    }

    // Lending Management
    public void checkoutBook(int bookId, int patronId, int branchId) {
        lendingManager.checkoutBook(bookId, patronId, branchId);
    }

    public void returnBook(int bookId, int patronId, int branchId) {
        lendingManager.returnBook(bookId, patronId, branchId);
    }

    public boolean isBookAvailable(int bookId, int branchId) {
        return lendingManager.isBookAvailable(bookId, branchId);
    }

    // Reservation Management
    public void reserveBook(int bookId, int patronId, int branchId) {
        lendingManager.reserveBook(bookId, patronId, branchId);
    }

    public void notifyPatron(int bookId, int branchId) {
        lendingManager.notifyPatron(bookId, branchId);
    }

    public List<Patron> getAllPatrons() {
        return patronManager.getAllPatron();
    }

    public List<Branch> getAllBranches() {
        return branches;
    }

    public List<Book> getAllBooks(int branchId) {
        Branch branch = getBranchById(branchId);
        if (branch != null) {
            return branch.getAllBooks();
        }
        return null;
    }

    public void addBook(Book book, int branchId) {
        Branch branch = getBranchById(branchId);
        if (branch != null) {
            branch.addBook(book);
        }
    }

    public void removeBook(int bookId, int branchId) {
        Branch branch = getBranchById(branchId);
        if (branch != null) {
            branch.removeBook(bookId);
        }
    }

    public void updateBook(Book book, int branchId) {
        Branch branch = getBranchById(branchId);
        if (branch != null) {
            branch.updateBook(book);
        }
    }

    public List<Book> searchBookByTitle(String title, int branchId) {
        Branch branch = getBranchById(branchId);
        if (branch != null) {
            return branch.findBookByTitle(title);
        }
        return null;
    }

    public List<Book> searchBookByAuthor(String author, int branchId) {
        Branch branch = getBranchById(branchId);
        if (branch != null) {
            return branch.findBookByAuthor(author);
        }
        return null;
    }

    public Book searchBookByISBN(String isbn, int branchId) {
        Branch branch = getBranchById(branchId);
        if (branch != null) {
            return branch.findBookByISBN(isbn);
        }
        return null;
    }
}