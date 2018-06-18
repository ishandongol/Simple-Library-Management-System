import java.util.ArrayList;
import java.util.List;

public class Database<T> implements DatabaseInterface<T> {

    private List<T> collection = new ArrayList<>();

    @Override
    public boolean create(T object) {
        return collection.add(object);
    }

    @Override
    public T read(int id) {
        return collection.get(id);
    }

    @Override
    public T update(int id, T newValue) {
       return collection.set(id,newValue);
    }

    @Override
    public boolean delete(T object) {
        System.out.println(object);
        return collection.remove(object);
    }

    public List<T> getCollection(){
        return collection;
    }

}
