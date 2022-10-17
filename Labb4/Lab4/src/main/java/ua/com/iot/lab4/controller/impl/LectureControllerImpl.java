package ua.com.iot.lab4.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ua.com.iot.lab4.controller.ILectureController;
import ua.com.iot.lab4.domain.Lecture;
import ua.com.iot.lab4.service.ILectureService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class LectureControllerImpl implements ILectureController {
    private ILectureService lectureService;

    @Override
    public List<Lecture> getAll() {
        return lectureService.getAll();
    }

    @Override
    public Optional<Lecture> getById(Integer id) {
        return lectureService.getById(id);
    }

    @Override
    public int create(Lecture lecture) {
        return lectureService.create(lecture);
    }

    @Override
    public int delete(Integer id) {
        return lectureService.delete(id);
    }

    @Override
    public int update(Integer id, Lecture lecture) {
        return lectureService.update(id, lecture);
    }
}