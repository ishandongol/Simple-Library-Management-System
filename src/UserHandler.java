
public class UserHandler extends Database<User> {

   public UserHandler(){
       create(new BasicUser(10,"Ishan","BasicUser"));
       create(new BasicUser(10,"Dongol","BasicUser"));
       create(new BasicUser(10,"Lognod","BasicUser"));
       create(new BasicUser(10,"Uttam","BasicUser"));
       create(new BasicUser(10,"Pratyush","BasicUser"));
       create(new BasicUser(10,"Data","BasicUser"));
   }
    @Override
    public boolean create(User object) {
        return super.create(object);
    }

    @Override
    public User read(int id) {
        int index =0;
        System.out.print("\033[H\033[2J");

        for(User user: super.getCollection()){
            if (user.getId()==id){
                return super.read(index);
            }
            index++;
        }
        return null;
    }

    public void read(String name) {
        int index =0;
        System.out.print("\033[H\033[2J");

        for(User user: super.getCollection()){
            if (user.getName().toLowerCase().matches("[0-9 a-zA-Z]*"+name.toLowerCase()+"[0-9 a-zA-Z]*")){
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
    public boolean delete(User object) {

        return super.delete(object);
    }
}
