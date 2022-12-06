package ua.com.iot.lab4.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ua.com.iot.lab4.controller.IStudentController;
import ua.com.iot.lab4.domain.Student;
import ua.com.iot.lab4.service.IStudentService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class StudentControllerImpl implements IStudentController {
    private IStudentService studentService;

    @Override
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @Override
    public Optional<Student> getById(Integer id) {
        return studentService.getById(id);
    }

    @Override
    public int create(Student student) {
        return studentService.create(student);
    }

    @Override
    public int delete(Integer id) {
        return studentService.delete(id);
    }

    @Override
    public int update(Integer id, Student student) {
        return studentService.update(id, student);
    }
}
