package ua.com.iot.lab4.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.iot.lab4.controller.ILectureController;
import ua.com.iot.lab4.dao.ILectureDao;
import ua.com.iot.lab4.domain.Lecture;
import ua.com.iot.lab4.service.ILectureService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LectureServiceImpl implements ILectureService {
    private ILectureDao lectureDao;

    @Override
    public List<Lecture> getAll() {
        return lectureDao.getAll();
    }

    @Override
    public Optional<Lecture> getById(Integer id) {
        return lectureDao.getById(id);
    }

    @Override
    public int create(Lecture lecture) {
        return lectureDao.create(lecture);
    }

    @Override
    public int delete(Integer id) {
        return lectureDao.delete(id);
    }

    @Override
    public int update(Integer id, Lecture lecture) {
        return lectureDao.update(id, lecture);
    }
}