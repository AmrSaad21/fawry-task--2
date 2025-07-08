public class ShowcaseBook extends Book {

    public ShowcaseBook(String ISBN, String title, String author, int publishYear, double price,
            String showcaseDetails) {
        super(ISBN, title, author, publishYear, price);
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Showcase books are not for sale");
    }

    @Override
    public String toString() {
        return super.toString() + " [Showcase - NOT FOR SALE]";
    }

}
