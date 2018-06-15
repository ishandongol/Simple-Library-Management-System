

public class Books {
    private int bookNumber;
    private String bookName;
    private String ISBN;
    private String author;
    private int copies;
    private float cost;

    public Books(int bookNumber, String bookName, String ISBN, String author, int copies, float cost) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.author = author;
        this.copies = copies;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "\nID: '" +
                this.getBookNumber() +
                "'\nName: '" +
                this.getBookName() +
                "'\nAuthor: '" +
                this.getAuthor() +
                "'\nISBN: '" +
                this.getISBN() +
                "'\nQuantity: '" +
                this.getCopies() +
                "'\nPrice: '" +
                this.getCost() +
                "'"
                ;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }

    public float getCost() {
        return cost;
    }
}
