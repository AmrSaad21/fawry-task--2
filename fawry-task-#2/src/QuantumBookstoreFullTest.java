import java.util.List;

class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();

        System.out.println("=== Testing Quantum Bookstore ===\n");

        // Test 1: Adding books
        store.addBook(new PaperBook("PB001", "PaperBook1", "Author1", 2020, 10.99, 5));
        store.addBook(new Ebook("EB001", "EBook1", "Author2", 2021, 8.99, "PDF"));
        store.addBook(new ShowcaseBook("SB001", "ShowcaseBook1", "Author3", 2019, 15.99, "Demo book"));
        store.addBook(new PaperBook("PB002", "PaperBook2", "Author4", 2022, 12.99, 3));
        store.addBook(new Ebook("EB002", "EBook2", "Author5", 2023, 9.99, "EPUB"));
        System.out.println();
        store.displayInventory();

        // Test 2: Buying books
        System.out.println("\n2. Testing book purchases:");
        try {
            double amount1 = store.buyBook("PB001", 2, "customer@email.com", "123 Main St");
            System.out.println("Quantum book store: Paid amount: $" + amount1);

            double amount2 = store.buyBook("EB001", 1, "customer@email.com", "123 Main St");
            System.out.println("Quantum book store: Paid amount: $" + amount2);

        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        // Test 3: Trying to buy showcase book (should fail)
        System.out.println("\n3. Testing showcase book purchase (should fail):");
        try {
            store.buyBook("SB001", 1, "customer@email.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        // Test 4: Buying more than available stock (should fail)
        System.out.println("\n4. Testing insufficient stock (should fail):");
        try {
            store.buyBook("PB001", 15, "customer@email.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        // Test 5: Removing outdated books
        System.out.println("\n5. Testing removal of outdated books (>15 years):");
        List<Book> removedBooks = store.removeOutdatedBooks(3);
        System.out.println("Quantum book store: Removed " + removedBooks.size() + " outdated books");

        System.out.println("\n6. Final inventory:");
        store.displayInventory();

        // Test 6: Buying non-existent book
        System.out.println("\n7. Testing non-existent book purchase (should fail):");
        try {
            store.buyBook("PB001", 1, "customer@email.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

    }
}