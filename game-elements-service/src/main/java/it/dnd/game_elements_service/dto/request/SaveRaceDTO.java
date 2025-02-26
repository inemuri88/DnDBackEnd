package it.dnd.game_elements_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveRaceDTO {
    private String name;
    private String description;
    private int baseSpeed;
    private Set<Long> languageIds;
    private String size;
    private String type;
    private String subtype;
    private String ageDescription;
    private String alignmentDescription;
    private int strengthModifier;
    private int dexterityModifier;
    private int constitutionModifier;
    private int intelligenceModifier;
    private int wisdomModifier;
    private int charismaModifier;
    private String racialAbilities;
    private String racialSkillBonuses;
    private int racialHitDice;
    private Long favoredClassId;
    private Set<Long> automaticLanguageIds;
    private Set<Long> bonusLanguageIds;
    private Integer flySpeed;
    private Integer swimSpeed;
    private Integer burrowSpeed;
    private int levelAdjustment;
}