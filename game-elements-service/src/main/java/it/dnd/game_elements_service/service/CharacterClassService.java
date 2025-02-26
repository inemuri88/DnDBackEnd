package it.dnd.game_elements_service.service;

import it.dnd.game_elements_service.dto.request.SaveCharacterClassDTO;

public interface CharacterClassService {

    SaveCharacterClassDTO saveClass(SaveCharacterClassDTO saveCharacterClassDTO);
}
