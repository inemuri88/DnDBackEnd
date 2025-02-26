package it.dnd.game_elements_service.dto.request;

import it.dnd.game_elements_service.model.Skill;
import it.dnd.game_elements_service.model.Spell;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveCharacterClassDTO {

    private String name;
    private String description;
    private String hitDie;
    private int skillPointsPerLevel;
    private String classSkillsText;
    private String baseAttackBonusType;
    private String fortitudeSaveType;
    private String reflexSaveType;
    private String willSaveType;
    private Set<Skill> classSkills;
    private Set<Spell> spells;
    private boolean spellCaster;
    private String spellsPerDayTable;
    private String specialAbilities;
}
