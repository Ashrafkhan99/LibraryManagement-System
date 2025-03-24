# Library Management System

This system provides a centralized solution for managing multiple library branches, their inventories, patrons, and lending operations. It supports book checkouts, returns, reservations, searching, and more.

## Core Concepts

This system is built around the following core concepts:

*   **LibrarySystem:** The central hub that orchestrates all library operations, including managing branches, patrons, and lending activities. It acts as the main entry point for interacting with the system.
*   **Branch:** Represents a physical library location, containing its own inventory of books and associated details (ID, name, address).
*   **Book:** Represents a library book, including its title, author, ISBN, publication year, unique ID, availability status, and quantity.
*   **Patron:** Represents a library member, with details like a unique ID, name, address, phone number, borrowing history, and reservations.
*   **PatronManager:** Responsible for managing the collection of patrons, including adding, updating, and removing them.
*   **LendingManager:** Handles all lending-related operations, such as checking out books, returning books, and managing reservations. It also interacts with a `NotificationService` to notify patrons about book availability.
*   **Reservation:** Represents a patron's request to reserve a book that is currently unavailable. It stores the patron, the book, and a unique reservation ID.
*   **InventoryManager:** Manages the book inventory within a specific branch, including adding, removing, and updating books. It also handles searching for books within the branch.
*   **NotificationService:** An interface for sending notifications to patrons. In the current implementation, `ConsoleNotifService` is used to send notifications to the console.
* **ConsoleNotifService:** A concrete implementation of the `NotificationService` that sends notifications to the console.

## Key Features

### Branch Management

*   **Multiple Branches:** Supports multiple library branches, each with its own unique inventory.
*   **Branch Details:** Each branch has a unique ID, name, and address.
*   **Add/Remove Branches:** Easily add new branches or remove existing ones.
*   **List All Branches:** Retrieve a list of all branches in the system.

### Book Management

*   **Book Details:** Stores comprehensive book information, including title, author, ISBN, publication year, unique ID, availability, and quantity.
*   **Add/Remove Books:** Add new books to specific branches or remove them from the inventory. The system handles adding multiple copies of the same book and removing individual copies.
*   **Update Books:** Modify existing book details.
*   **Book Availability:** Tracks the availability of each book (available or checked out) and the quantity of copies.
*   **Search:** Search for books by title, author, or ISBN within a specific branch.
*   **List All Books:** Retrieve a list of all books within a specific branch.

### Patron Management

*   **Patron Details:** Stores patron information, including a unique ID, name, address, and phone number.
*   **Borrowing History:** Tracks each patron's borrowing history.
*   **Add/Remove Patrons:** Add new patrons or remove existing ones.
*   **Update Patrons:** Modify existing patron details.
*   **List All Patrons:** Retrieve a list of all registered patrons.

### Lending Management

*   **Checkout:** Patrons can check out available books from a specific branch. The system decrements the book's quantity upon checkout.
*   **Return:** Patrons can return borrowed books to the branch they borrowed them from. The system increments the book's quantity upon return.
*   **Reservation:** Patrons can reserve books that are currently checked out. The system manages a queue of reservations for each book.
*   **Availability Check:** Check if a book is available at a specific branch.
*   **Notification:** When a reserved book becomes available, the system automatically notifies the patron who reserved it via the `NotificationService`.
* **Quantity Management:** The system tracks the quantity of each book. When a book is checked out, its quantity is reduced. When it's returned, the quantity is increased. If the quantity reaches zero, the book is marked as unavailable.

### Additional Features

* **Multiple Copies:** The system supports multiple copies of the same book.
* **Search Functionality:** The system allows searching for books by title, author, and ISBN.
* **Removing Book:** The system allows removing a book from the library. If the book has multiple copies, it will reduce the quantity. If the quantity is 1, it will remove the book.
* **Removing Patron:** The system allows removing a patron from the library.
* **Updating Book:** The system allows updating the book details.
* **Updating Patron:** The system allows updating the patron details.

## Application Workflow

1.  **Initialization:** The `LibrarySystem` is created, and branches are added.
2.  **Adding Books:** Books are added to specific branches, with quantity tracking.
3.  **Adding Patrons:** Patrons are registered in the system.
4.  **Checkout:** A patron requests to check out a book from a branch. The `LendingManager` handles this, updating the book's availability and quantity, and the patron's borrowing history.
5.  **Return:** A patron returns a book. The `LendingManager` updates the book's availability and quantity, and the patron's borrowing history.
6.  **Reservation:** If a book is unavailable, a patron can reserve it. The `LendingManager` manages the reservation queue.
7.  **Notification:** When a reserved book is returned, the `LendingManager` uses the `NotificationService` to notify the next patron in the reservation queue.
8.  **Searching:** Users can search for books by title, author, or ISBN within a specific branch.
9.  **Removing:** Books or patrons can be removed from the system.
10. **Updating:** Book or patron details can be updated.
11. **Transferring:** Books can be transfered from one branch to another (not implemented in the provided code, but the design allows for it).

## Assumptions

*   **Centralized System:** The Library Management System is designed as a centralized system that manages multiple branches and serves patrons accordingly.
*   **Integration:** The system is designed to be integrated into libraries with other scaling factors.
*   **Console Notifications:** The current implementation uses `ConsoleNotifService` for notifications. This can be extended to other notification methods (e.g., email, SMS).
* **Unique Book IDs:** Each book has a unique ID within the entire system.
* **Unique Patron IDs:** Each patron has a unique ID within the entire system.
* **Unique Branch IDs:** Each branch has a unique ID within the entire system.

## Box Diagram

https://excalidraw.com/#json=shsrdkqgWYzkVxvD8wpZc,4SDdeecNBxjgkOvd5cgmTQ


![image](https://github.com/user-attachments/assets/ceeb7cfc-48d7-4c4e-a529-df19f2efbdf2)

