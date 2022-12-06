package ua.com.iot.lab4.dao.impl;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.iot.lab4.dao.IStudentDao;
import ua.com.iot.lab4.domain.Student;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class StudentDaoImpl implements IStudentDao {
    private static final String GET_BY_ID = "SELECT * FROM student WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM student";
    private static final String CREATE = "INSERT INTO student (id, name, group_id,age) VALUES (?, ?, ?,?)";
    private static final String DELETE = "DELETE FROM student WHERE id=?";
    private static final String UPDATE = "UPDATE student SET name=?,group_id=?,age=?, WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getAll() {
        return jdbcTemplate.query(GET_ALL, BeanPropertyRowMapper.newInstance(Student.class));
    }

    @Override
    public Optional<Student> getById(Integer id) {
        Optional<Student> student;
        try {
            student = Optional.ofNullable(
                    jdbcTemplate.queryForObject(GET_BY_ID, BeanPropertyRowMapper.newInstance(Student.class), id));
        } catch (EmptyResultDataAccessException e) {
            student = Optional.empty();
        }
        return student;
    }

    @Override
    public int create(@NotNull Student student) {
        return jdbcTemplate.update(CREATE, student.getId(),student.getName(), student.getGroupId(), student.getAge());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, @NotNull Student student) {
        return jdbcTemplate.update(UPDATE,  student.getName(), student.getGroupId(), student.getAge(), id);
    }
}
