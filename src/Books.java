import java.util.ArrayList;
import java.util.List;

public class Books {
    private int bookNumber;
    private String bookName;
    private String ISBN;
    private String author;
    private int copies;
    private float cost;
    List<User> issuedBu = new ArrayList<>();

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
                "'\nIssued By: '" +
                this.getIssuedBy() +
                "'"
                ;
    }

    private List<User> getIssuedBy() {
        return  issuedBu;
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

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public boolean issued(User user) {
        if(getCopies()>0){
            this.setCopies(this.getCopies()-1);
            return issuedBu.add(user);
        }else{
            System.out.println("Out of Stock");
        }
        return false;
    }
    public boolean returnBooks(User user){
       return this.getIssuedBy().remove(user);

    }

    public void updateBooksQuantity() {
        this.setCopies(this.getCopies()+1);
    }
}
