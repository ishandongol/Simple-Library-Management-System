import java.util.Arrays;

public class BookHandler extends Database<Books>{

    public BookHandler(){
        System.out.println("BookHandler Opened" );
        initialize(new Books(0010,"Java Programming","ISBN 989-99-99-8","Dongol",40,97.8f));
        initialize(new Books(0020,"Android Programming","ISBN 989-99-99-8","Dongol",50,97.8f));
        initialize(new Books(0030,"Python Programming","ISBN 989-99-99-8","Dongol",60,57.8f));
        initialize(new Books(0040,"ReactJS","ISBN 989-99-99-8","Dongol",60,27.8f));
        initialize(new Books(0050,"React Native","ISBN 989-99-99-8","Dongol",40,87.8f));
    }


    public boolean create(Books object, User currentUser) {
       if(Authentication.authenticate(currentUser)){
           System.out.println("\nBook" + object+"\nInserted");

           return super.create(object);
       }
        System.out.println("BasicUser Not Authorized to Create");
        return false;

    }



    private void initialize(Books object) {
        System.out.println("Books Inserted");
        super.create(object);
    }

    @Override
    public Books read(int id) {
        int index =0;
        for(Books book: super.getCollection()){
            if (book.getBookNumber()==id){
                return super.read(index);
            }
            index++;
        }
        return null;
    }

    public void read(String name) {
        int index =0;
        System.out.print("\033[H\033[2J");

        for(Books book: super.getCollection()){
            if (book.getBookName().toLowerCase().matches("[0-9 a-zA-Z]*"+name.toLowerCase()+"[0-9 a-zA-Z]*")){
                System.out.println(super.read(index));
            }
            index++;
        }
    }

    @Override
    public boolean update() {
        return super.update();
    }

    @Override
    public boolean delete(Books object) {
        return super.delete(object);
    }
}
