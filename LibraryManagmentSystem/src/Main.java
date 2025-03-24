import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a LibrarySystem instance
        LibrarySystem librarySystem = new LibrarySystem();

        // Create branches
        Branch branch1 = new Branch(1, "Old City Hyderabad", "123 Main St");
        Branch branch2 = new Branch(2, "Madhapur", "456 Oak Ave");
        librarySystem.addBranch(branch1);
        librarySystem.addBranch(branch2);
        System.out.println("--------------------All branches in library--------------------");
        List<Branch> allBranches = librarySystem.getAllBranches();
        allBranches.forEach(System.out::println);

        // Add books to branch1 with different quantities
        Book book1 = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "978-0345391803", 1979, 1, 4); // 4 copies
        Book book2 = new Book("Pride and Prejudice", "Jane Austen", "978-0141439518", 1813, 2, 3); // 3 copies
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0446310789", 1960, 3, 2); // 2 copies
        librarySystem.addBook(book1, 1);
        librarySystem.addBook(book2, 1);
        librarySystem.addBook(book3, 1);
        System.out.println("--------------------All books in branch 1 (initial)--------------------");
        List<Book> allBooksBranch1 = librarySystem.getAllBooks(1);
        allBooksBranch1.forEach(System.out::println);

        // Add more copies of an existing book
        System.out.println("--------------------Adding more copies of book1 to branch 1--------------------");
        Book book1MoreCopies = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "978-0345391803", 1979, 1, 2); // Adding 2 more copies
        librarySystem.addBook(book1MoreCopies, 1);
        System.out.println("--------------------All books in branch 1 (after adding more copies)--------------------");
        allBooksBranch1 = librarySystem.getAllBooks(1);
        allBooksBranch1.forEach(System.out::println);

        // Add books to branch2
        Book book4 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0618054760", 1954, 4, 1); // 1 copy
        Book book5 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0547928227", 1937, 5, 6); // 6 copies
        librarySystem.addBook(book4, 2);
        librarySystem.addBook(book5, 2);
        System.out.println("--------------------All books in branch 2--------------------");
        List<Book> allBooksBranch2 = librarySystem.getAllBooks(2);
        allBooksBranch2.forEach(System.out::println);

        // Add some patrons
        Patron patron1 = new Patron(1, "Alice Smith", "123 Main St", "555-1234");
        Patron patron2 = new Patron(2, "Bob Johnson", "456 Oak Ave", "555-5678");
        librarySystem.addPatron(patron1);
        librarySystem.addPatron(patron2);
        System.out.println("--------------------All patrons in library--------------------");
        List<Patron> allPatrons = librarySystem.getAllPatrons();
        allPatrons.forEach(System.out::println);

        // Checkout scenarios
        System.out.println("--------------------Checkout scenarios--------------------");
        System.out.println("Alice checks out book1 from branch1 (1 copy)");
        librarySystem.checkoutBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice checks out book1 from branch1 (2 copy)");
        librarySystem.checkoutBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice checks out book1 from branch1 (3 copy)");
        librarySystem.checkoutBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice checks out book1 from branch1 (4 copy)");
        librarySystem.checkoutBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice checks out book1 from branch1 (5 copy)");
        librarySystem.checkoutBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice checks out book1 from branch1 (6 copy)");
        librarySystem.checkoutBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));

        // Return scenarios
        System.out.println("--------------------Return scenarios--------------------");
        System.out.println("Alice returns book1 to branch1");
        librarySystem.returnBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice returns book1 to branch1");
        librarySystem.returnBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice returns book1 to branch1");
        librarySystem.returnBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice returns book1 to branch1");
        librarySystem.returnBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice returns book1 to branch1");
        librarySystem.returnBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));
        System.out.println("Alice returns book1 to branch1");
        librarySystem.returnBook(1, 1, 1);
        System.out.println("Is book id 1 available in branch 1? " + librarySystem.isBookAvailable(1, 1));

        // Reserve a book in branch 1
        System.out.println("--------------------Reserve a book in branch 1--------------------");
        librarySystem.reserveBook(1, 2, 1); // Bob reserves book1 in branch1
        System.out.println("--------------------Return a book to branch 1--------------------");
        librarySystem.returnBook(1, 1, 1); // Alice return book 1 to branch 1, it will notify Bob

        // Transfer a book from branch 1 to branch 2
        System.out.println("--------------------Transfer a book from branch 1 to branch 2--------------------");
        librarySystem.transferBook(2, 1, 2); // Transfer book2 from branch1 to branch2
        System.out.println("--------------------All books in branch 1 after transfer--------------------");
        List<Book> allBooksBranch1AfterTransfer = librarySystem.getAllBooks(1);
        allBooksBranch1AfterTransfer.forEach(System.out::println);
        System.out.println("--------------------All books in branch 2 after transfer--------------------");
        List<Book> allBooksBranch2AfterTransfer = librarySystem.getAllBooks(2);
        allBooksBranch2AfterTransfer.forEach(System.out::println);

        // Search for a book in branch 2
        System.out.println("--------------------Search for book by title in branch 2--------------------");
        List<Book> searchResultByTitle = librarySystem.searchBookByTitle("Lord", 2);
        searchResultByTitle.forEach(System.out::println);

        System.out.println("--------------------Search for book by author in branch 2--------------------");
        List<Book> searchResultByAuthor = librarySystem.searchBookByAuthor("J.R.R. Tolkien", 2);
        searchResultByAuthor.forEach(System.out::println);

        System.out.println("--------------------Search for book by isbn in branch 2--------------------");
        Book searchResultByISBN = librarySystem.searchBookByISBN("978-0547928227", 2);
        System.out.println(searchResultByISBN);

        // Remove book scenarios
        System.out.println("--------------------Remove a Book in branch 2--------------------");
        System.out.println("Removing book 5 (6 copies)");
        librarySystem.removeBook(5, 2);
        System.out.println("Removing book 5 (5 copies)");
        librarySystem.removeBook(5, 2);
        System.out.println("Removing book 5 (4 copies)");
        librarySystem.removeBook(5, 2); // Remove one copy
        System.out.println("Removing book 5 (3 copies)");
        librarySystem.removeBook(5, 2);
        System.out.println("Removing book 5 (2 copies)");
        librarySystem.removeBook(5, 2);
        System.out.println("Removing book 5 (1 copies)");
        librarySystem.removeBook(5, 2);
        System.out.println("Removing book 5 (0 copies)");
        librarySystem.removeBook(5, 2);
        List<Book> booksAfterRemoving = librarySystem.getAllBooks(2);
        booksAfterRemoving.forEach(System.out::println);

        // Update a book
        System.out.println("--------------------Update a book in branch 2--------------------");
        Book updatedBook = new Book("The Lord of the Rings Updated", "J.R.R. Tolkien", "978-0618054760", 1955, 4, 1);
        librarySystem.updateBook(updatedBook, 2);
        List<Book> updatedBooks = librarySystem.getAllBooks(2);
        updatedBooks.forEach(System.out::println);

        // Remove a patron
        System.out.println("--------------------Remove a Patron--------------------");
        librarySystem.removePatron(2);
        List<Patron> patronAfterRemoving = librarySystem.getAllPatrons();
        patronAfterRemoving.forEach(System.out::println);

        // Update a patron
        System.out.println("--------------------Update a patron--------------------");
        Patron updatedPatron = new Patron(1, "Alice Smith Updated", "123 main street updated", "000-000-000");
        librarySystem.updatePatron(updatedPatron);
        List<Patron> patronAfterUpdate = librarySystem.getAllPatrons();
        patronAfterUpdate.forEach(System.out::println);
    }
}