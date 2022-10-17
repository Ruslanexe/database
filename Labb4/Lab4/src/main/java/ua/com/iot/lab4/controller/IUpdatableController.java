package ua.com.iot.lab4.controller;

public interface IUpdatableController<T, ID> extends IGeneralController<T, ID> {
    int update(ID id, T entity);
}
