package ma.enset.mohammedia;

import java.util.List;

public interface IMetier<T> {
    public void add(T obj);
    public void remove(Long id);
    public T findById(Long id);
    public List<T> getAll();
}
