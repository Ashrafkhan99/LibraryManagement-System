import java.util.List;

public class Branch {
    private int branchId;
    private String name;
    private String address;
    private InventoryManager inventoryManager;

    public Branch(int branchId, String name, String address) {
        this.branchId = branchId;
        this.name = name;
        this.address = address;
        this.inventoryManager = new InventoryManager();
    }

    public int getBranchId() {
        return branchId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }
    public List<Book> getAllBooks(){
        return inventoryManager.getAllBooks();
    }
    public void addBook(Book book){
        inventoryManager.addBook(book);
    }
    public void removeBook(int bookId){
        inventoryManager.removeBook(bookId);
    }
    public void updateBook(Book book){
        inventoryManager.updateBook(book);
    }
    public List<Book> findBookByTitle(String title){
        return inventoryManager.findBookByTitle(title);
    }
    public List<Book> findBookByAuthor(String author){
        return inventoryManager.findBookByAuthor(author);
    }
    public Book findBookByISBN(String isbn){
        return inventoryManager.findBookByISBN(isbn);
    }
    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}