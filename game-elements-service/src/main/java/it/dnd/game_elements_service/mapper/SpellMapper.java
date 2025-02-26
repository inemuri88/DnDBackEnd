package it.dnd.game_elements_service.mapper;


import it.dnd.game_elements_service.dto.SpellDTO;
import it.dnd.game_elements_service.dto.request.SaveSpellDTO;
import it.dnd.game_elements_service.model.Spell;
import org.springframework.stereotype.Component;

import java.util.List;


public interface SpellMapper {

    SpellDTO toDto(Spell spell);

    Spell toModel(SpellDTO spellDto);

    List<SpellDTO> toDtos(List<Spell> spell);

    SaveSpellDTO toSaveDto(Spell spell);

    Spell toModel(SaveSpellDTO spellDto);
}
