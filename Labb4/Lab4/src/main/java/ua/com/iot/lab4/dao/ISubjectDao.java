package ua.com.iot.lab4.dao;

import ua.com.iot.lab4.controller.IGeneralController;
import ua.com.iot.lab4.controller.IUpdatableController;
import ua.com.iot.lab4.domain.Subject;

import java.util.List;
import java.util.Optional;
public interface ISubjectDao extends IUpdatableController<Subject, Integer> {
}

