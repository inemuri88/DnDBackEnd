package it.dnd.game_elements_service.mapper;

import it.dnd.game_elements_service.dto.RaceDTO;
import it.dnd.game_elements_service.dto.request.SaveRaceDTO;
import it.dnd.game_elements_service.model.CharacterClass;
import it.dnd.game_elements_service.model.Language;
import it.dnd.game_elements_service.model.Race;
import it.dnd.game_elements_service.repository.CharacterClassRepository;
import it.dnd.game_elements_service.repository.LanguageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RaceMapperImpl implements RaceMapper {

    private final LanguageRepository languageRepository;
    private final CharacterClassRepository characterClassRepository;

    @Override
    public Race toModel(RaceDTO raceDTO) {
        return Race.builder()
                .id(raceDTO.getId())
                .name(raceDTO.getName())
                .description(raceDTO.getDescription())
                .baseSpeed(raceDTO.getBaseSpeed())
                .size(raceDTO.getSize())
                .type(raceDTO.getType())
                .subtype(raceDTO.getSubtype())
                .ageDescription(raceDTO.getAgeDescription())
                .alignmentDescription(raceDTO.getAlignmentDescription())
                .strengthModifier(raceDTO.getStrengthModifier())
                .dexterityModifier(raceDTO.getDexterityModifier())
                .constitutionModifier(raceDTO.getConstitutionModifier())
                .intelligenceModifier(raceDTO.getIntelligenceModifier())
                .wisdomModifier(raceDTO.getWisdomModifier())
                .charismaModifier(raceDTO.getCharismaModifier())
                .racialAbilities(raceDTO.getRacialAbilities())
                .racialSkillBonuses(raceDTO.getRacialSkillBonuses())
                .racialHitDice(raceDTO.getRacialHitDice())
                .favoredClass(mapFavoredClass(raceDTO.getFavoredClassId()))
                .languages(mapLanguages(raceDTO.getLanguageIds()))
                .automaticLanguages(mapLanguages(raceDTO.getAutomaticLanguageIds()))
                .bonusLanguages(mapLanguages(raceDTO.getBonusLanguageIds()))
                .flySpeed(raceDTO.getFlySpeed())
                .swimSpeed(raceDTO.getSwimSpeed())
                .burrowSpeed(raceDTO.getBurrowSpeed())
                .levelAdjustment(raceDTO.getLevelAdjustment())
                .build();
    }

    //TODO: Da inserire nel service questi due metodi ( da decidere ancora )
    private Set<Language> mapLanguages(Set<Long> languageIds) {
        return new HashSet<>(languageRepository.findAllById(languageIds));
    }


    private CharacterClass mapFavoredClass(Long favoredClassId) {
        return characterClassRepository.findById(favoredClassId)
                .orElseThrow(() -> new EntityNotFoundException("Favored class not found"));
    }


    @Override
    public RaceDTO toDTO(Race race) {
        if (race == null) {
            return null;
        }

        return RaceDTO.builder()
                .id(race.getId())
                .name(race.getName())
                .description(race.getDescription())
                .baseSpeed(race.getBaseSpeed())
                .size(race.getSize())
                .type(race.getType())
                .subtype(race.getSubtype())
                .ageDescription(race.getAgeDescription())
                .alignmentDescription(race.getAlignmentDescription())
                .strengthModifier(race.getStrengthModifier())
                .dexterityModifier(race.getDexterityModifier())
                .constitutionModifier(race.getConstitutionModifier())
                .intelligenceModifier(race.getIntelligenceModifier())
                .wisdomModifier(race.getWisdomModifier())
                .charismaModifier(race.getCharismaModifier())
                .racialAbilities(race.getRacialAbilities())
                .racialSkillBonuses(race.getRacialSkillBonuses())
                .racialHitDice(race.getRacialHitDice())
                .favoredClassId(race.getFavoredClass() != null ? race.getFavoredClass().getId() : null)
                .languageIds(race.getLanguages().stream()
                        .map(Language::getId)
                        .collect(Collectors.toSet()))
                .automaticLanguageIds(race.getAutomaticLanguages().stream()
                        .map(Language::getId)
                        .collect(Collectors.toSet()))
                .bonusLanguageIds(race.getBonusLanguages().stream()
                        .map(Language::getId)
                        .collect(Collectors.toSet()))
                .flySpeed(race.getFlySpeed())
                .swimSpeed(race.getSwimSpeed())
                .burrowSpeed(race.getBurrowSpeed())
                .levelAdjustment(race.getLevelAdjustment())
                .build();
    }

    @Override
    public List<Race> toModels(List<RaceDTO> raceDTOList) {
        if (raceDTOList == null || raceDTOList.isEmpty()) {
            return Collections.emptyList();
        }

        return raceDTOList.stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public List<RaceDTO> toDTOs(List<Race> raceList) {
        if (raceList == null || raceList.isEmpty()) {
            return Collections.emptyList();
        }

        return raceList.stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public Race toModel(SaveRaceDTO raceDTO) {
        return Race.builder()
                .name(raceDTO.getName())
                .description(raceDTO.getDescription())
                .baseSpeed(raceDTO.getBaseSpeed())
                .size(raceDTO.getSize())
                .type(raceDTO.getType())
                .subtype(raceDTO.getSubtype())
                .ageDescription(raceDTO.getAgeDescription())
                .alignmentDescription(raceDTO.getAlignmentDescription())
                .strengthModifier(raceDTO.getStrengthModifier())
                .dexterityModifier(raceDTO.getDexterityModifier())
                .constitutionModifier(raceDTO.getConstitutionModifier())
                .intelligenceModifier(raceDTO.getIntelligenceModifier())
                .wisdomModifier(raceDTO.getWisdomModifier())
                .charismaModifier(raceDTO.getCharismaModifier())
                .racialAbilities(raceDTO.getRacialAbilities())
                .racialSkillBonuses(raceDTO.getRacialSkillBonuses())
                .racialHitDice(raceDTO.getRacialHitDice())
                .favoredClass(mapFavoredClass(raceDTO.getFavoredClassId()))
                .languages(mapLanguages(raceDTO.getLanguageIds()))
                .automaticLanguages(mapLanguages(raceDTO.getAutomaticLanguageIds()))
                .bonusLanguages(mapLanguages(raceDTO.getBonusLanguageIds()))
                .flySpeed(raceDTO.getFlySpeed())
                .swimSpeed(raceDTO.getSwimSpeed())
                .burrowSpeed(raceDTO.getBurrowSpeed())
                .levelAdjustment(raceDTO.getLevelAdjustment())
                .build();
    }

    @Override
    public SaveRaceDTO toSaveDTO(Race race) {
        if (race == null) {
            return null;
        }

        return SaveRaceDTO.builder()
                .name(race.getName())
                .description(race.getDescription())
                .baseSpeed(race.getBaseSpeed())
                .size(race.getSize())
                .type(race.getType())
                .subtype(race.getSubtype())
                .ageDescription(race.getAgeDescription())
                .alignmentDescription(race.getAlignmentDescription())
                .strengthModifier(race.getStrengthModifier())
                .dexterityModifier(race.getDexterityModifier())
                .constitutionModifier(race.getConstitutionModifier())
                .intelligenceModifier(race.getIntelligenceModifier())
                .wisdomModifier(race.getWisdomModifier())
                .charismaModifier(race.getCharismaModifier())
                .racialAbilities(race.getRacialAbilities())
                .racialSkillBonuses(race.getRacialSkillBonuses())
                .racialHitDice(race.getRacialHitDice())
                .favoredClassId(race.getFavoredClass() != null ? race.getFavoredClass().getId() : null)
                .languageIds(race.getLanguages().stream()
                        .map(Language::getId)
                        .collect(Collectors.toSet()))
                .automaticLanguageIds(race.getAutomaticLanguages().stream()
                        .map(Language::getId)
                        .collect(Collectors.toSet()))
                .bonusLanguageIds(race.getBonusLanguages().stream()
                        .map(Language::getId)
                        .collect(Collectors.toSet()))
                .flySpeed(race.getFlySpeed())
                .swimSpeed(race.getSwimSpeed())
                .burrowSpeed(race.getBurrowSpeed())
                .levelAdjustment(race.getLevelAdjustment())
                .build();
    }
}

