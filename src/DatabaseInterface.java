public interface DatabaseInterface<T> {

    boolean create(T object);
    T read(int id);
    boolean update();
    boolean delete(T object);

}
