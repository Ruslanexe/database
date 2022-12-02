package ua.lviv.iot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.controller.FiremanController;
import ua.lviv.iot.domain.FireTeam;
import ua.lviv.iot.domain.Fireman;
import ua.lviv.iot.dto.FiremanDto;
import ua.lviv.iot.exeption.FiremanNotFoundException;
import ua.lviv.iot.repository.FiremanRepository;
import ua.lviv.iot.service.FiremanService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class FiremanServiceImpl implements FiremanService {
    @Autowired
    private FiremanRepository firemanRepository;

    @Override
    public List<Fireman> findAll() {
        return firemanRepository.findAll();
    }

    @Override
    public Fireman findById(Integer integer) {
        return firemanRepository.findById(integer).orElseThrow(() -> new FiremanNotFoundException(integer));
    }

    @Transactional
    @Override
    public Fireman create(Fireman entity) {
        return firemanRepository.save(entity);
    }

    @Transactional
    @Override
    public void update(Integer integer, Fireman entity) {

        Fireman fireman = firemanRepository.findById(integer).orElseThrow(() -> new FiremanNotFoundException(integer));
        fireman.setDepartures(entity.getDepartures());
        fireman.setName(entity.getName());
        fireman.setSurname(entity.getSurname());
        fireman.setFireTeamId(entity.getFireTeamId());

        firemanRepository.save(fireman);
    }

    @Transactional
    @Override
    public void delete(Integer integer) {
        firemanRepository.deleteById(integer);
    }

    @Override
    public FiremanDto insertWithProcedure(FiremanDto firemanDto) {

        Integer id = firemanRepository.insertWithProcedure(firemanDto.getFire_team_id(),firemanDto.getSurname(), firemanDto.getName()
               );

        Link selfLink = linkTo(methodOn(FiremanController.class).getFireman(id)).withSelfRel();
        firemanDto.add(selfLink);
        return firemanDto;
    }
}
