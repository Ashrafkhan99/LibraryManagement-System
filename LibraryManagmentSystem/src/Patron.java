import java.util.ArrayList;
import java.util.List;

public class Patron {
    private int patronId;
    private String name;
    private String address;
    private String phoneNumber;
    private List<Book> borrowingHistory;

    public Patron(int patronId, String name, String address, String phoneNumber) {
        this.patronId = patronId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowingHistory = new ArrayList<>();
    }

    // Getters and Setters...

    public int getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Book> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void addToBorrowingHistory(Book book) {
        borrowingHistory.add(book);
    }

    public void removeFromBorrowingHistory(Book book) {
        borrowingHistory.remove(book);
    }

    @Override
    public String toString() {
        return "Patron{" +
                "patronId=" + patronId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowingHistory=" + borrowingHistory +
                '}';
    }
}
