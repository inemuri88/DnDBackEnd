package it.dnd.game_elements_service.service;


import it.dnd.game_elements_service.dto.RaceDTO;
import it.dnd.game_elements_service.dto.request.SaveRaceDTO;
import it.dnd.game_elements_service.model.Race;

import java.util.List;

public interface RaceService {

    RaceDTO getRace(Long id);
    List<RaceDTO> getAllRaces();
    SaveRaceDTO saveRace(SaveRaceDTO raceDTO);
    void deleteRace(Long id);
    RaceDTO updateRace(RaceDTO race);

}
