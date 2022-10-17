package ua.com.iot.lab4.dao;
import java.util.List;
import java.util.Optional;

public interface IGeneralDao<T, ID> {
    List<T> getAll();

    Optional<T> getById(ID id);

    int create(T entity);

    int delete(ID id);
}

