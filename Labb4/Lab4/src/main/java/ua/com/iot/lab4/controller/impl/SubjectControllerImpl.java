package ua.com.iot.lab4.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ua.com.iot.lab4.controller.ISubjectController;
import ua.com.iot.lab4.domain.Subject;
import ua.com.iot.lab4.service.ISubjectService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class SubjectControllerImpl implements ISubjectController {
    private ISubjectService subjectService;

    @Override
    public List<Subject> getAll() {
        return subjectService.getAll();
    }

    @Override
    public Optional<Subject> getById(Integer id) {
        return subjectService.getById(id);
    }

    @Override
    public int create(Subject subject) {
        return subjectService.create(subject);
    }

    @Override
    public int delete(Integer id) {
        return subjectService.delete(id);
    }

    @Override
    public int update(Integer id, Subject subject) {
        return subjectService.update(id, subject);
    }
}
