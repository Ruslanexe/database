package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.service.ProceduresService;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value= "/api/procedures")
public class ProceduresController{
    @Autowired
    ProceduresService proceduresService;

    @PostMapping("/insertion_into_fire_man/{new_fireteam_id}/{new_name}/{new_surname}")
    public Integer insertion_into_fire_man(@PathVariable Integer new_fireteam_id, @PathVariable String new_name, @PathVariable String new_surname){
        return proceduresService.insertion_into_fire_man(new_fireteam_id, new_name, new_surname);
    }

    @PostMapping("/insertion_into_client_gym_M_to_M/{new_gym_id}/{new_client_id}")
    public void insertion_into_client_gym_M_to_M(@PathVariable Integer new_gym_id, @PathVariable Integer new_client_id){
        proceduresService.insertion_into_client_gym_M_to_M(new_gym_id, new_client_id);
    }

    @PostMapping("/InsertLinesToFireteam")
    public void InsertLinesToFireteam(){
        proceduresService.InsertLinesToFireteam();
    }

    @PostMapping("/ProcCursor")
    public void ProcCursor(){
        proceduresService.ProcCursor();
    }

    @GetMapping("/exercise_complexity_avg")
    public int exercise_complexity_avg(){
        return proceduresService.exercise_complexity_avg();
    }
}
