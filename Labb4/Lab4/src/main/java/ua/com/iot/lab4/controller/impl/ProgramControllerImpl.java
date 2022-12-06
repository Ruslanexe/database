package ua.com.iot.lab4.controller.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ua.com.iot.lab4.controller.IProgramController;
import ua.com.iot.lab4.domain.Program;
import ua.com.iot.lab4.service.IProgramService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ProgramControllerImpl implements IProgramController {
    private IProgramService programService;

    @Override
    public List<Program> getAll() {
        return programService.getAll();
    }

    @Override
    public Optional<Program> getById(Integer id) {
        return programService.getById(id);
    }

    @Override
    public int create(Program program) {
        return programService.create(program);
    }

    @Override
    public int delete(Integer id) {
        return programService.delete(id);
    }

    @Override
    public int update(Integer id, Program program) {
        return programService.update(id, program);
    }
}

