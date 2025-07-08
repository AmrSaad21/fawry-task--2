public class Ebook extends Book {
    private String fileType;

    public Ebook(String ISBN, String title, String author, int publishYear, double price, String fileType) {
        super(ISBN, title, author, publishYear, price);
        this.fileType = fileType;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        MailService.sendEBookd(this, quantity, email);
    }

    @Override
    public String toString() {
        return super.toString() + ", Ebook{" +
                "fileType='" + fileType + '\'' +
                '}';
    }

    public String getFileType() {
        return fileType;
    }

}