package ua.com.iot.lab4.dao.impl;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.iot.lab4.dao.ISubjectDao;
import ua.com.iot.lab4.domain.Subject;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SubjectDaoImpl implements ISubjectDao {
    private static final String GET_BY_ID = "SELECT * FROM subject WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM subject";
    private static final String CREATE = "INSERT INTO subject (id, name, duration,difficulty) VALUES (?, ?, ?,?)";
    private static final String DELETE = "DELETE FROM subject WHERE id=?";
    private static final String UPDATE = "UPDATE subject SET name=?,duration=?,difficulty=?, WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Subject> getAll() {
        return jdbcTemplate.query(GET_ALL, BeanPropertyRowMapper.newInstance(Subject.class));
    }

    @Override
    public Optional<Subject> getById(Integer id) {
        Optional<Subject> subject;
        try {
            subject = Optional.ofNullable(
                    jdbcTemplate.queryForObject(GET_BY_ID, BeanPropertyRowMapper.newInstance(Subject.class), id));
        } catch (EmptyResultDataAccessException e) {
            subject = Optional.empty();
        }
        return subject;
    }

    @Override
    public int create(@NotNull Subject subject) {
        return jdbcTemplate.update(CREATE, subject.getId(),subject.getName(), subject.getDuration(), subject.getDifficulty());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, @NotNull Subject subject) {
        return jdbcTemplate.update(UPDATE, subject.getName(), subject.getDuration(), subject.getDifficulty(), id);
    }
}
