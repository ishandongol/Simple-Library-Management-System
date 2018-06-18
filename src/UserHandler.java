
public class UserHandler extends Database<User> {
private int index;
    public UserHandler() {
        create(new Student(10, "Ishan", "Student"));
        create(new Student(20, "Dongol", "student"));
        create(new Student(30, "Lognod", "Student"));
        create(new Student(40, "Uttam", "Student"));
        create(new Student(50, "Pratyush", "Student"));
        create(new Student(60, "Data", "Student"));
    }

    @Override
    public boolean create(User object) {
        return super.create(object);
    }

    @Override
    public User read(int id) {
         index = 0;
        System.out.print("\033[H\033[2J");

        for (User user : super.getCollection()) {
            if (user.getId() == id) {
                return super.read(index);
            }
            index++;
        }
        return null;
    }

    public void read(String name) {
        int index = 0;
        System.out.print("\033[H\033[2J");

        for (User user : super.getCollection()) {
            if (user.getName().toLowerCase().matches("[0-9 a-zA-Z]*" + name.toLowerCase() + "[0-9 a-zA-Z]*")) {
                System.out.println(super.read(index));
            }
            index++;
        }
    }

    @Override
    public User update(int id, User newValue) {
        read(id);
        return super.update(index, newValue);
    }

    @Override
    public boolean delete(User object) {

        return super.delete(object);
    }
}
