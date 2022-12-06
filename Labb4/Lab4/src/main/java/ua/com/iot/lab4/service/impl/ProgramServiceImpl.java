package ua.com.iot.lab4.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.iot.lab4.controller.IProgramController;
import ua.com.iot.lab4.dao.IProgramDao;
import ua.com.iot.lab4.domain.Program;
import ua.com.iot.lab4.service.IProgramService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProgramServiceImpl implements IProgramService {
    private IProgramDao programDao;

    @Override
    public List<Program> getAll() {
        return programDao.getAll();
    }

    @Override
    public Optional<Program> getById(Integer id) {
        return programDao.getById(id);
    }

    @Override
    public int create(Program program) {
        return programDao.create(program);
    }

    @Override
    public int delete(Integer id) {
        return programDao.delete(id);
    }

    @Override
    public int update(Integer id, Program program) {
        return programDao.update(id, program);
    }
}
