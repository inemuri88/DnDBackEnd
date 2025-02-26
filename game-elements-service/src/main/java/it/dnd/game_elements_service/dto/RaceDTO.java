package it.dnd.game_elements_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RaceDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    private Integer baseSpeed;
    private String size;
    private String type;
    private String subtype;
    private String ageDescription;
    private String alignmentDescription;

    private Integer strengthModifier;
    private Integer dexterityModifier;
    private Integer constitutionModifier;
    private Integer intelligenceModifier;
    private Integer wisdomModifier;
    private Integer charismaModifier;

    private String racialAbilities;
    private String racialSkillBonuses;
    private Integer racialHitDice;

    private Long favoredClassId;

    private Set<Long> languageIds;
    private Set<Long> automaticLanguageIds;
    private Set<Long> bonusLanguageIds;

    private Integer flySpeed;
    private Integer swimSpeed;
    private Integer burrowSpeed;
    private Integer levelAdjustment;
}
