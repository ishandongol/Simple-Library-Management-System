public interface DatabaseInterface<T> {

    boolean create(T object);
    T read(int id);
    T update(int id, T newValue);
    boolean delete(T object);

}
