package it.dnd.game_elements_service.mapper;

import it.dnd.game_elements_service.dto.RaceDTO;
import it.dnd.game_elements_service.dto.request.SaveRaceDTO;
import it.dnd.game_elements_service.model.Race;

import java.util.List;

public interface RaceMapper {

    Race toModel(RaceDTO raceDTO);

    RaceDTO toDTO(Race race);

    List<Race> toModels(List<RaceDTO> raceDTOList);

    List<RaceDTO> toDTOs(List<Race> raceList);

    Race toModel(SaveRaceDTO raceDTO);

    SaveRaceDTO toSaveDTO(Race race);
}