package ua.lviv.iot.service;

public interface ProceduresService {
    Integer insertion_into_fire_man(Integer new_fireteam_id, String new_name, String new_surname);

    
    void insertion_into_client_gym_M_to_M(Integer new_gym_id, Integer new_client_id);

    
    void InsertLinesToFireteam();

    
    void ProcCursor();

    
    int exercise_complexity_avg();
}
