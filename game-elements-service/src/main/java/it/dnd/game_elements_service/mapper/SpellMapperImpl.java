package it.dnd.game_elements_service.mapper;

import it.dnd.game_elements_service.dto.SpellDTO;
import it.dnd.game_elements_service.dto.request.SaveSpellDTO;
import it.dnd.game_elements_service.model.Spell;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SpellMapperImpl implements SpellMapper {
    @Override
    public SpellDTO toDto(Spell spell) {
        if (spell == null) {
            return null;
        }

        return new SpellDTO(
                spell.getId(),
                spell.getName(),
                spell.getDescription(),
                spell.getClasses(),
                spell.getLevel(),
                spell.getCastingTime(),
                spell.getRange(),
                spell.getDuration(),
                spell.getComponents(),
                spell.getSchool(),
                spell.isConcentration()
        );
    }

    @Override
    public Spell toModel(SpellDTO spellDto) {
        if (spellDto == null) {
            return null;
        }

        return Spell.builder()
                .id(spellDto.getId())
                .name(spellDto.getName())
                .description(spellDto.getDescription())
                .classes(spellDto.getClasses())
                .level(spellDto.getLevel())
                .castingTime(spellDto.getCastingTime())
                .range(spellDto.getRange())
                .duration(spellDto.getDuration())
                .components(spellDto.getComponents())
                .school(spellDto.getSchool())
                .concentration(spellDto.isConcentration())
                .build();
    }

    @Override
    public List<SpellDTO> toDtos(List<Spell> spells) {
        if (spells == null) {
            return Collections.emptyList();
        }

        return spells.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public SaveSpellDTO toSaveDto(Spell spell) {
        if (spell == null) {
            return null;
        }

        return new SaveSpellDTO(
                spell.getName(),
                spell.getDescription(),
                spell.getClasses(),
                spell.getLevel(),
                spell.getCastingTime(),
                spell.getRange(),
                spell.getDuration(),
                spell.getComponents(),
                spell.getSchool(),
                spell.isConcentration()
        );
    }

    @Override
    public Spell toModel(SaveSpellDTO saveSpellDto) {
        if (saveSpellDto == null) {
            return null;
        }

        return Spell.builder()
                .name(saveSpellDto.getName())
                .description(saveSpellDto.getDescription())
                .classes(saveSpellDto.getClasses())
                .level(saveSpellDto.getLevel())
                .castingTime(saveSpellDto.getCastingTime())
                .range(saveSpellDto.getRange())
                .duration(saveSpellDto.getDuration())
                .components(saveSpellDto.getComponents())
                .school(saveSpellDto.getSchool())
                .concentration(saveSpellDto.isConcentration())
                .build();
    }
}