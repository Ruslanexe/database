package ua.com.iot.lab4.controller;

import java.util.List;
import java.util.Optional;

public interface IGeneralController<T, ID> {
    List<T> getAll();

    Optional<T> getById(ID id);

    int create(T entity);

    int delete(ID id);
}

