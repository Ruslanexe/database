package ua.com.iot.lab4.dao;

import ua.com.iot.lab4.controller.IGeneralController;

public interface IUpdatableDao<T, ID> extends IGeneralController<T, ID> {
    int update(ID id, T entity);
}
