package it.dnd.game_elements_service.mapper;

import it.dnd.game_elements_service.dto.request.SaveCharacterClassDTO;
import it.dnd.game_elements_service.model.CharacterClass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CharacterClassMapperImpl implements CharacterClassMapper{
    @Override
    public CharacterClass toModel(SaveCharacterClassDTO saveCharacterClassDTO) {
        return CharacterClass.builder()
                .name(saveCharacterClassDTO.getName())
                .classSkillsText(saveCharacterClassDTO.getClassSkillsText())
                .hitDie(saveCharacterClassDTO.getHitDie())
                .description(saveCharacterClassDTO.getDescription())
                .baseAttackBonusType(saveCharacterClassDTO.getBaseAttackBonusType())
                .skillPointsPerLevel(saveCharacterClassDTO.getSkillPointsPerLevel())
                .specialAbilities(saveCharacterClassDTO.getSpecialAbilities())
                .spells(saveCharacterClassDTO.getSpells())
                .spellCaster(saveCharacterClassDTO.isSpellCaster())
                .fortitudeSaveType(saveCharacterClassDTO.getFortitudeSaveType())
                .reflexSaveType(saveCharacterClassDTO.getReflexSaveType())
                .willSaveType(saveCharacterClassDTO.getWillSaveType())
                .spellsPerDayTable(saveCharacterClassDTO.getSpellsPerDayTable())
                .classSkills(saveCharacterClassDTO.getClassSkills())
                .build();
    }

    @Override
    public SaveCharacterClassDTO toSaveDTO(CharacterClass characterClass) {
        return SaveCharacterClassDTO.builder()
                .name(characterClass.getName())
                .classSkillsText(characterClass.getClassSkillsText())
                .hitDie(characterClass.getHitDie())
                .description(characterClass.getDescription())
                .baseAttackBonusType(characterClass.getBaseAttackBonusType())
                .skillPointsPerLevel(characterClass.getSkillPointsPerLevel())
                .specialAbilities(characterClass.getSpecialAbilities())
                .spells(characterClass.getSpells())
                .spellCaster(characterClass.isSpellCaster())
                .fortitudeSaveType(characterClass.getFortitudeSaveType())
                .reflexSaveType(characterClass.getReflexSaveType())
                .willSaveType(characterClass.getWillSaveType())
                .spellsPerDayTable(characterClass.getSpellsPerDayTable())
                .classSkills(characterClass.getClassSkills())
                .build();
    }
}
