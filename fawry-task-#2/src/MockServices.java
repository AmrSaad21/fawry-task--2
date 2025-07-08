class ShippingService {
    public static void ship(PaperBook book, int quantity, String address) {
        System.out.println("Quantum book store: Shipping " + quantity + " copy(ies) of '" +
                book.getTitle() + "' to address: " + address);
    }
}

class MailService {
    public static void sendEBookd(Ebook book, int quantity, String email) {
        System.out.println("Quantum book store: Sending " + quantity + " copy(ies) of '" +
                book.getTitle() + "' (" + book.getFileType() + ") to email: " + email);
    }
}