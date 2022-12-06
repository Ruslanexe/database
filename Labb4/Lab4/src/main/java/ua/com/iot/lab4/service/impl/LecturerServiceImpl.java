package ua.com.iot.lab4.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.iot.lab4.controller.ILecturerController;
import ua.com.iot.lab4.dao.ILecturerDao;
import ua.com.iot.lab4.domain.Lecturer;
import ua.com.iot.lab4.service.ILecturerService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LecturerServiceImpl implements ILecturerService {
    private ILecturerDao lecturerDao;

    @Override
    public List<Lecturer> getAll() {
        return lecturerDao.getAll();
    }

    @Override
    public Optional<Lecturer> getById(Integer id) {
        return lecturerDao.getById(id);
    }

    @Override
    public int create(Lecturer lecturer) {
        return lecturerDao.create(lecturer);
    }

    @Override
    public int delete(Integer id) {
        return lecturerDao.delete(id);
    }

    @Override
    public int update(Integer id, Lecturer lecturer) {
        return lecturerDao.update(id, lecturer);
    }
}

