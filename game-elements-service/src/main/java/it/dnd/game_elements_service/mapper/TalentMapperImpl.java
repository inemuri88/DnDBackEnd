package it.dnd.game_elements_service.mapper;

import it.dnd.game_elements_service.dto.TalentDTO;
import it.dnd.game_elements_service.dto.request.SaveTalentDTO;
import it.dnd.game_elements_service.model.Talent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class TalentMapperImpl implements TalentMapper {

    @Override
    public TalentDTO toDto(Talent talent) {
        List<String> prerequisitesList = (talent.getPrerequisites() != null)
                ? Arrays.asList(talent.getPrerequisites().split(","))
                : null;

        return new TalentDTO(
                talent.getId(),
                talent.getName(),
                talent.getDescription(),
                prerequisitesList,
                talent.getBenefits()
        );
    }

    //OverLoading
    @Override
    public Talent toModel(TalentDTO talentDto) {
        String prerequisitesString = (talentDto.getPrerequisites() != null)
                ? String.join(",", talentDto.getPrerequisites())
                : null;

        Talent talent = new Talent();
        talent.setId(talentDto.getId());
        talent.setName(talentDto.getName());
        talent.setDescription(talentDto.getDescription());
        talent.setPrerequisites(prerequisitesString);
        talent.setBenefits(talentDto.getBenefits());

        return talent;
    }

    @Override
    public Talent toModel(SaveTalentDTO talentDto) {
        String prerequisitesString = (talentDto.getPrerequisites() != null)
                ? String.join(",", talentDto.getPrerequisites())
                : null;

        Talent talent = new Talent();
        talent.setName(talentDto.getName());
        talent.setDescription(talentDto.getDescription());
        talent.setPrerequisites(prerequisitesString);
        talent.setBenefits(talentDto.getBenefits());

        return talent;
    }

    @Override
    public List<TalentDTO> toDtos(List<Talent> talents) {
        if (talents == null) {
            return Collections.emptyList();
        }

        return talents.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public SaveTalentDTO toSaveDto(Talent talent) {
        List<String> prerequisitesList = (talent.getPrerequisites() != null)
                ? Arrays.asList(talent.getPrerequisites().split(","))
                : null;

        return new SaveTalentDTO(
                talent.getName(),
                talent.getDescription(),
                prerequisitesList,
                talent.getBenefits()
        );
    }


}

