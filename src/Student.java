import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private List<Books> issuedBooks = new ArrayList<>();

    public Student(int id, String name, String occupation){
        System.out.println("User Created");
        super.setId(id);
        super.setName(name);
        super.setOccupation(occupation);
    }


    public List<Books> getIssuedBooks() {
        return issuedBooks;
    }

    public boolean setIssuedBooks(Books books) {
        if(totalBooksIssued()<5){
          return  this.issuedBooks.add(books);
        }
        System.out.println("Maximum books Issued");
        return false;
    }

    private int totalBooksIssued(){
        return issuedBooks.size();
    }

    @Override
    public String toString() {
        return "\nID: '" +
                super.getId() +
                "'\nName: '" +
                super.getName() +
                "'\nOccupation: '" +
                super.getOccupation() +
                "'\nIssued Books Total: '" +
                this.totalBooksIssued() +

                "'"
                ;
    }
}
