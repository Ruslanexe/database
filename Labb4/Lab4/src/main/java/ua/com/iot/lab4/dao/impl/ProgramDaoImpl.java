package ua.com.iot.lab4.dao.impl;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.iot.lab4.dao.IProgramDao;
import ua.com.iot.lab4.domain.Program;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProgramDaoImpl implements IProgramDao {
    private static final String GET_BY_ID = "SELECT * FROM program WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM program";
    private static final String CREATE = "INSERT INTO program (id, name, description) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM program WHERE id=?";
    private static final String UPDATE = "UPDATE program SET name=?,description=?, WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Program> getAll() {
        return jdbcTemplate.query(GET_ALL, BeanPropertyRowMapper.newInstance(Program.class));
    }

    @Override
    public Optional<Program> getById(Integer id) {
        Optional<Program> program;
        try {
            program = Optional.ofNullable(
                    jdbcTemplate.queryForObject(GET_BY_ID, BeanPropertyRowMapper.newInstance(Program.class), id));
        } catch (EmptyResultDataAccessException e) {
            program = Optional.empty();
        }
        return program;
    }

    @Override
    public int create(@NotNull Program program) {
        return jdbcTemplate.update(CREATE, program.getId(), program.getName(), program.getDescription());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, @NotNull Program program) {
        return jdbcTemplate.update(UPDATE,  program.getName(), program.getDescription(), id);
    }
}

