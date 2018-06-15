
public class BasicUser extends User {

    public BasicUser(int id, String name, String occupation){
        System.out.println("User Created");
        setId(id);
        setName(name);
        setOccupation(occupation);
    }

}
