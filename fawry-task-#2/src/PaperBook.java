public class PaperBook extends Book {
    int stock;

    public PaperBook(String ISBN, String title, String author, int publishYear, double price, int stock) {
        super(ISBN, title, author, publishYear, price);
        this.stock = stock;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        if (quantity > stock) {
            throw new UnsupportedOperationException("Insufficient stock for " + title + ". Available: " + stock);

        } else {
            stock -= quantity;
            ShippingService.ship(this, quantity, address);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", PaperBook{" +
                "stock=" + stock +
                '}';
    }

    public int getStock() {
        return stock;
    }

}
