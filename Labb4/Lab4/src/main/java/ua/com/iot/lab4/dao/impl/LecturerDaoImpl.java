package ua.com.iot.lab4.dao.impl;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.iot.lab4.dao.ILecturerDao;
import ua.com.iot.lab4.domain.Lecturer;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class LecturerDaoImpl implements ILecturerDao {
    private static final String GET_BY_ID = "SELECT * FROM lecturer WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM lecturer";
    private static final String CREATE = "INSERT INTO lecturer (id, name, type) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM lecturer WHERE id=?";
    private static final String UPDATE = "UPDATE lecturer SET name=?,type=?, WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Lecturer> getAll() {
        return jdbcTemplate.query(GET_ALL, BeanPropertyRowMapper.newInstance(Lecturer.class));
    }

    @Override
    public Optional<Lecturer> getById(Integer id) {
        Optional<Lecturer> lecturer;
        try {
            lecturer = Optional.ofNullable(
                    jdbcTemplate.queryForObject(GET_BY_ID, BeanPropertyRowMapper.newInstance(Lecturer.class), id));
        } catch (EmptyResultDataAccessException e) {
            lecturer = Optional.empty();
        }
        return lecturer;
    }

    @Override
    public int create(@NotNull Lecturer lecturer) {
        return jdbcTemplate.update(CREATE, lecturer.getId(), lecturer.getName(), lecturer.getType());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, @NotNull Lecturer lecturer) {
        return jdbcTemplate.update(UPDATE,  lecturer.getName(), lecturer.getType(), id);
    }
}
