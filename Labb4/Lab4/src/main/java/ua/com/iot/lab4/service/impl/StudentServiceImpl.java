package ua.com.iot.lab4.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.iot.lab4.controller.IStudentController;
import ua.com.iot.lab4.dao.IStudentDao;
import ua.com.iot.lab4.domain.Student;
import ua.com.iot.lab4.service.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao;

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Optional<Student> getById(Integer id) {
        return studentDao.getById(id);
    }

    @Override
    public int create(Student student) {
        return studentDao.create(student);
    }

    @Override
    public int delete(Integer id) {
        return studentDao.delete(id);
    }

    @Override
    public int update(Integer id, Student student) {
        return studentDao.update(id, student);
    }
}
