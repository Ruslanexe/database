package ua.com.iot.lab4.service;

import ua.com.iot.lab4.controller.IGeneralController;

public interface IUpdatableService<T, ID> extends IGeneralService<T, ID> {
    int update(ID id, T entity);
}
