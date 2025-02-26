package it.dnd.game_elements_service.service;

import it.dnd.game_elements_service.dto.TalentDTO;
import it.dnd.game_elements_service.dto.request.SaveTalentDTO;
import it.dnd.game_elements_service.exception.TalentException;


import java.util.List;

public interface TalentService {

    TalentDTO getTalent(Long id);

    List<TalentDTO> getAllTalents();

    SaveTalentDTO saveTalent(SaveTalentDTO saveTalentDto);

    boolean hasTalentAsPrerequisite (TalentDTO talentDto) throws TalentException;

    boolean checkTalentPrerequisite(TalentDTO talentDto);

}
