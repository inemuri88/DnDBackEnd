package it.dnd.game_elements_service.mapper;

import it.dnd.game_elements_service.dto.RaceDTO;
import it.dnd.game_elements_service.dto.request.SaveCharacterClassDTO;
import it.dnd.game_elements_service.dto.request.SaveRaceDTO;
import it.dnd.game_elements_service.model.CharacterClass;
import it.dnd.game_elements_service.model.Race;

import java.util.List;

public interface CharacterClassMapper {

//    CharacterClass toModel(RaceDTO raceDTO);
//
//    RaceDTO toDTO(Race race);
//
//    List<CharacterClass> toModels(List<RaceDTO> raceDTOList);
//
//    List<RaceDTO> toDTOs(List<CharacterClass> raceList);

    CharacterClass toModel(SaveCharacterClassDTO saveCharacterClassDTO);

    SaveCharacterClassDTO toSaveDTO(CharacterClass characterClass);
}
