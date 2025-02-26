package it.dnd.game_elements_service.service;

import it.dnd.game_elements_service.dto.SpellDTO;
import it.dnd.game_elements_service.dto.request.SaveSpellDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface SpellService {

    SpellDTO getSpell(Long id);

    List<SpellDTO> getAllSpell();

    SaveSpellDTO saveSpell( SaveSpellDTO saveTalentDto);

    void deleteSpell(Long id);
}
