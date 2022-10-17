package ua.com.iot.lab4.dao.impl;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.iot.lab4.dao.IFeedbackDao;
import ua.com.iot.lab4.domain.Feedback;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class FeedbackDaoImpl implements IFeedbackDao {
    private static final String GET_BY_ID = "SELECT * FROM feedback WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM feedback";
    private static final String CREATE = "INSERT INTO feedback (id, response, mark, student_id,lecture_id) VALUES (?, ?, ?, ?,?)";
    private static final String DELETE = "DELETE FROM feedback WHERE id=?";
    private static final String UPDATE = "UPDATE feedback SET response=?,mark=?,student_id=?,lecture_id=?, WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Feedback> getAll() {
        return jdbcTemplate.query(GET_ALL, BeanPropertyRowMapper.newInstance(Feedback.class));
    }

    @Override
    public Optional<Feedback> getById(Integer id) {
        Optional<Feedback> feedback;
        try {
            feedback = Optional.ofNullable(
                    jdbcTemplate.queryForObject(GET_BY_ID, BeanPropertyRowMapper.newInstance(Feedback.class), id));
        } catch (EmptyResultDataAccessException e) {
            feedback = Optional.empty();
        }
        return feedback;
    }

    @Override
    public int create(@NotNull Feedback feedback) {
        return jdbcTemplate.update(CREATE, feedback.getId(), feedback.getResponse(),  feedback.getMark(),feedback.getStudentId(),feedback.getLectureId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, @NotNull Feedback feedback) {
        return jdbcTemplate.update(UPDATE, feedback.getResponse(),  feedback.getMark(),feedback.getStudentId(),feedback.getLectureId(), id);
    }
}





