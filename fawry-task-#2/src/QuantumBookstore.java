import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

class QuantumBookstore {
    private Map<String, Book> inventory;

    public QuantumBookstore() {
        this.inventory = new HashMap<>();
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
        System.out.println("Quantum book store: Added book - " + book);
    }

    public List<Book> removeOutdatedBooks(int yearsThreshold) {
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();

            if (book.isOutdated(yearsThreshold)) {
                removedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book);
            }
        }

        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found");
        }

        if (book instanceof ShowcaseBook) {
            throw new UnsupportedOperationException("Showcase books are not for sale");
        }

        double totalAmount = book.getPrice() * quantity;

        try {
            book.processPurchase(quantity, email, address);
            System.out.println("Quantum book store: Purchase successful - " + quantity +
                    " copy(ies) of '" + book.getTitle() + "' for $" + totalAmount);
            return totalAmount;
        } catch (Exception e) {
            throw e;
        }
    }

    public void displayInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("Quantum book store: No books in inventory");
        } else {
            inventory.values().forEach(book -> System.out.println("Quantum book store: " + book));
        }
    }
}
