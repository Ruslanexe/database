package ua.com.iot.lab4.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.iot.lab4.controller.ISubjectController;
import ua.com.iot.lab4.dao.ISubjectDao;
import ua.com.iot.lab4.domain.Subject;
import ua.com.iot.lab4.service.ISubjectService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements ISubjectService {
    private ISubjectDao subjectDao;

    @Override
    public List<Subject> getAll() {
        return subjectDao.getAll();
    }

    @Override
    public Optional<Subject> getById(Integer id) {
        return subjectDao.getById(id);
    }

    @Override
    public int create(Subject subject) {
        return subjectDao.create(subject);
    }

    @Override
    public int delete(Integer id) {
        return subjectDao.delete(id);
    }

    @Override
    public int update(Integer id, Subject subject) {
        return subjectDao.update(id, subject);
    }
}
