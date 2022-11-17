package ua.lviv.iot.service;

import ua.lviv.iot.domain.Fireman;
import ua.lviv.iot.dto.FiremanDto;

public interface FiremanService extends GeneralService<Fireman, Integer> {
    FiremanDto insertWithProcedure(FiremanDto firemanDto);
}
