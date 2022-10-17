package ua.com.iot.lab4.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ua.com.iot.lab4.controller.IGroupController;
import ua.com.iot.lab4.dao.IGroupDao;
import ua.com.iot.lab4.domain.Group;
import ua.com.iot.lab4.service.IGroupService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements IGroupService {
    private IGroupDao groupDao;

    @Override
    public List<Group> getAll() {
        return groupDao.getAll();
    }

    @Override
    public Optional<Group> getById(Integer id) {
        return groupDao.getById(id);
    }

    @Override
    public int create(Group group) {
        return groupDao.create(group);
    }

    @Override
    public int delete(Integer id) {
        return groupDao.delete(id);
    }

    @Override
    public int update(Integer id, Group group) {
        return groupDao.update(id, group);
    }
}

