package ua.com.iot.lab4.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ua.com.iot.lab4.controller.ILecturerController;
import ua.com.iot.lab4.domain.Lecturer;
import ua.com.iot.lab4.service.ILecturerService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class LecturerControllerImpl implements ILecturerController {
    private ILecturerService lecturerService;

    @Override
    public List<Lecturer> getAll() {
        return lecturerService.getAll();
    }

    @Override
    public Optional<Lecturer> getById(Integer id) {
        return lecturerService.getById(id);
    }

    @Override
    public int create(Lecturer lecturer) {
        return lecturerService.create(lecturer);
    }

    @Override
    public int delete(Integer id) {
        return lecturerService.delete(id);
    }

    @Override
    public int update(Integer id, Lecturer lecturer) {
        return lecturerService.update(id, lecturer);
    }
}



