package ua.com.iot.lab4.dao.impl;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.iot.lab4.dao.IGroupDao;
import ua.com.iot.lab4.domain.Group;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class GroupDaoImpl implements IGroupDao {
    private static final String GET_BY_ID = "SELECT * FROM group WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM group";
    private static final String CREATE = "INSERT INTO group (id, number, program_id,) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM group WHERE id=?";
    private static final String UPDATE = "UPDATE group SET number=?,program_id=?, WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Group> getAll() {
        return jdbcTemplate.query(GET_ALL, BeanPropertyRowMapper.newInstance(Group.class));
    }

    @Override
    public Optional<Group> getById(Integer id) {
        Optional<Group> group;
        try {
            group = Optional.ofNullable(
                    jdbcTemplate.queryForObject(GET_BY_ID, BeanPropertyRowMapper.newInstance(Group.class), id));
        } catch (EmptyResultDataAccessException e) {
            group = Optional.empty();
        }
        return group;
    }

    @Override
    public int create(@NotNull Group group) {
        return jdbcTemplate.update(CREATE, group.getId(), group.getNumber());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, @NotNull Group group) {
        return jdbcTemplate.update(UPDATE, group.getNumber(),  group.getProgramId(), id);
    }
}
