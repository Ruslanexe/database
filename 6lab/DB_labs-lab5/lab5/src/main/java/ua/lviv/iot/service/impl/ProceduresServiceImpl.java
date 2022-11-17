package ua.lviv.iot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.repository.ProceduresRepository;
import ua.lviv.iot.service.ProceduresService;

@Service
public class ProceduresServiceImpl implements ProceduresService {
    @Autowired
    ProceduresRepository proceduresRepository;
    @Override
    public Integer insertion_into_fire_man(Integer new_fireteam_id, String new_name, String new_surname){
        return proceduresRepository.insertion_into_fire_man(new_fireteam_id, new_name, new_surname);
    }

    @Override
    public void insertion_into_client_gym_M_to_M(Integer new_gym_id, Integer new_client_id){
        proceduresRepository.insertion_into_client_gym_M_to_M(new_gym_id, new_client_id);
    }

    @Override
    public void InsertLinesToFireteam(){
        proceduresRepository.InsertLinesToFireteam();
    }

    @Override
    public void ProcCursor(){
        proceduresRepository.ProcCursor();
    }

    @Override
    public int exercise_complexity_avg(){
        return proceduresRepository.exercise_complexity_avg();
    }
}
