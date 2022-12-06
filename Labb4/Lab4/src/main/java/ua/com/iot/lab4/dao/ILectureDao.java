package ua.com.iot.lab4.dao;

import ua.com.iot.lab4.controller.IGeneralController;
import ua.com.iot.lab4.domain.Lecture;
import ua.com.iot.lab4.controller.IUpdatableController;
import java.util.List;
import java.util.Optional;
public interface ILectureDao extends IUpdatableController<Lecture, Integer> {
}