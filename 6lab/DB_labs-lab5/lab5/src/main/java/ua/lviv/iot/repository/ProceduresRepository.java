package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Departure;

@Repository
public interface ProceduresRepository extends JpaRepository<Departure, Integer> {
    @Procedure
    Integer insertion_into_fire_man(Integer new_fireteam_id, String new_name, String new_surname);

    @Procedure
    void insertion_into_client_gym_M_to_M(Integer new_gym_id, Integer new_client_id);

    @Procedure
    void InsertLinesToFireteam();

    @Procedure
    void ProcCursor();

    @Procedure
    Integer exercise_complexity_avg();
}
