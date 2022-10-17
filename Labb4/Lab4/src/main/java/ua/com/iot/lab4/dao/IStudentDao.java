package ua.com.iot.lab4.dao;
import ua.com.iot.lab4.controller.IGeneralController;
import ua.com.iot.lab4.controller.IUpdatableController;
import ua.com.iot.lab4.domain.Student;

import java.util.List;
import java.util.Optional;
public interface IStudentDao extends IUpdatableController<Student, Integer> {
}
