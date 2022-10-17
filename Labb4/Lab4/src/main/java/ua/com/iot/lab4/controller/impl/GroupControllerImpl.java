package ua.com.iot.lab4.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ua.com.iot.lab4.controller.IGroupController;
import ua.com.iot.lab4.domain.Group;
import ua.com.iot.lab4.service.IGroupService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class GroupControllerImpl implements IGroupController {
    private IGroupService groupService;

    @Override
    public List<Group> getAll() {
        return groupService.getAll();
    }

    @Override
    public Optional<Group> getById(Integer id) {
        return groupService.getById(id);
    }

    @Override
    public int create(Group group) {
        return groupService.create(group);
    }

    @Override
    public int delete(Integer id) {
        return groupService.delete(id);
    }

    @Override
    public int update(Integer id, Group group) {return groupService.update(id, group);
    }
}



