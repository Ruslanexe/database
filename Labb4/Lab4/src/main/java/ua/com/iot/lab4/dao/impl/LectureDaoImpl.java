package ua.com.iot.lab4.dao.impl;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.iot.lab4.dao.ILectureDao;
import ua.com.iot.lab4.domain.Lecture;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class LectureDaoImpl implements ILectureDao {
    private static final String GET_BY_ID = "SELECT * FROM lecture WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM lecture";
    private static final String CREATE = "INSERT INTO lecture (id, date, topic,group_id,subject_id,lecturer_id) VALUES (?, ?, ?,?, ?,)";
    private static final String DELETE = "DELETE FROM lecture WHERE id=?";
    private static final String UPDATE = "UPDATE lecture SET date=?,topic=?,group_id=?,subject_id=?,lecturer_id=?, WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Lecture> getAll() {
        return jdbcTemplate.query(GET_ALL, BeanPropertyRowMapper.newInstance(Lecture.class));
    }

    @Override
    public Optional<Lecture> getById(Integer id) {
        Optional<Lecture> lecture;
        try {
            lecture = Optional.ofNullable(
                    jdbcTemplate.queryForObject(GET_BY_ID, BeanPropertyRowMapper.newInstance(Lecture.class), id));
        } catch (EmptyResultDataAccessException e) {
            lecture = Optional.empty();
        }
        return lecture;
    }

    @Override
    public int create(@NotNull Lecture lecture) {
        return jdbcTemplate.update(CREATE, lecture.getId(), lecture.getDate(), lecture.getTopic(), lecture.getGroupId(), lecture.getSubjectId(),lecture.getLecturerId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, @NotNull Lecture lecture) {
        return jdbcTemplate.update(UPDATE,  lecture.getDate(), lecture.getTopic(), lecture.getGroupId(), lecture.getSubjectId(),lecture.getLecturerId(), id);
    }
}
