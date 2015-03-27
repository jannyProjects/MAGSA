package sk.tuke.magsa.framework;

import java.util.List;

public interface CRUDDao<T extends Entity> {
    void create(T object);

    void edit(T object);

    void remove(T object);

    T find(Integer id);

    List<T> selectAll();
}
