# LibraryManagement-System

-------------------------------------------------------------Core Components-------------------------------------------------------------
LibrarySystem: The central class that manages branches, patrons, and lending operations.
Branch: Represents a library branch, containing its inventory and details.
Book: Represents a book with its details (title, author, ISBN, etc.).
Patron: Represents a library patron with their details and borrowing history.
PatronManager: Manages the collection of patrons.
LendingManager: Handles book checkouts, returns, and reservations.
Reservation: Represents a book reservation made by a patron.
InventoryManager: Manages the books in a branch.


-------------------------------------------------------------Application-----------------------------------------------------------------
Initialization: The LibrarySystem is created, and branches are added.
Adding Books: Books are added to specific branches.
Adding Patrons: Patrons are registered in the system.
Checkout: A patron requests to check out a book from a branch. The LendingManager handles this, updating the book's availability and the patron's borrowing history.
Return: A patron returns a book. The LendingManager updates the book's availability and the patron's borrowing history.
Reservation: If a book is unavailable, a patron can reserve it. The LendingManager keeps track of reservations.
Transfer: A book can be transfered from one branch to another.
Searching: You can search for books by title, author and ISBN.
Removing: You can remove a book or a patron from the library.
Updating: You can update a book or a patron details.

-------------------------------------------------------------Key Features---------------------------------------------------------------
Branch Management:
Multiple Branches: The system supports multiple library branches, each with its own inventory.
Branch Details: Each branch has a unique ID, name, and address.
Adding/Removing Branches: You can add new branches and remove existing ones.
Getting all branches: You can get all the branches in the library.
Book Management:
Book Details: Each book has a title, author, ISBN, publication year, unique ID, and availability status.
Adding/Removing Books: Books can be added to or removed from specific branches.
Updating Books: Book details can be updated.
Book Availability: The system tracks whether a book is currently available or checked out.
Searching: You can search for books by title, author and ISBN.
Getting all books: You can get all the books in a specific branch.
Patron Management:
Patron Details: Each patron has a unique ID, name, address, and phone number.
Borrowing History: The system keeps track of each patron's borrowing history.
Adding/Removing Patrons: Patrons can be added or removed from the system.
Updating Patrons: Patron details can be updated.
Getting all patrons: You can get all the patrons in the library.
Lending Management:
Checkout: Patrons can check out books from a specific branch.
Return: Patrons can return books to the branch they borrowed them from.
Reservation: Patrons can reserve books that are currently checked out.
Availability Check: You can check if a book is available in a specific branch.
Notification: When a reserved book is returned, the system notifies the patron who reserved it.
Book Transfers:
Transferring Books: Books can be transferred between different library branches.
