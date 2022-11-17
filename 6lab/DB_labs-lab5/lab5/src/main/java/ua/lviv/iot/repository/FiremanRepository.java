package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ua.lviv.iot.domain.Fireman;

public interface FiremanRepository extends JpaRepository<Fireman, Integer> {
    @Procedure("insertion_into_fire_man")
    Integer insertWithProcedure(@Param("new_fireteam_id") Integer fireteam_id,@Param("new_surname") String surname, @Param("new_name") String name
                                );
}
