package it.dnd.game_elements_service.mapper;

import it.dnd.game_elements_service.dto.TalentDTO;
import it.dnd.game_elements_service.dto.request.SaveTalentDTO;
import it.dnd.game_elements_service.model.Talent;
import org.springframework.stereotype.Component;

import java.util.List;



public interface TalentMapper {

    TalentDTO toDto(Talent talent);

    Talent toModel(TalentDTO talentDto);

    List<TalentDTO> toDtos(List<Talent> talent);

    SaveTalentDTO toSaveDto(Talent talent);

    Talent toModel(SaveTalentDTO talentDto);
}

