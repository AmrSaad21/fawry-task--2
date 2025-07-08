import java.time.LocalDate;

public abstract class Book {
    protected String ISBN;
    protected String title;
    protected String author;
    protected int publishYear;
    protected double price;

    public Book(String ISBN, String title, String author, int publishYear, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", price=" + price +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getPrice() {
        return price;
    }

    public abstract void processPurchase(int quantity, String email, String address);

    // Check if book is outdated
    public boolean isOutdated(int yearsThreshold) {
        return LocalDate.now().getYear() - publishYear > yearsThreshold;
    }

}
