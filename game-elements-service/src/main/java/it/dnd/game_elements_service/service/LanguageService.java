package it.dnd.game_elements_service.service;

import it.dnd.game_elements_service.dto.LanguageDTO;
import it.dnd.game_elements_service.dto.request.SaveLanguageDTO;
import it.dnd.game_elements_service.model.Language;
import it.dnd.game_elements_service.model.Race;

import java.util.List;

public interface LanguageService {

    LanguageDTO getLanguage(Long id);
    List<LanguageDTO> getAllLanguages();
    SaveLanguageDTO saveLanguage(SaveLanguageDTO languageDTO);
    void deleteLanguage(Long id);
    boolean isAutomaticLanguage(Language language, Race race);
    boolean isBonusLanguage(Language language, Race race);
    boolean hasAvailableLanguageSlots(Race race, int currentLanguagesCount);
    boolean isValidLanguageChoice(Race race, Language language, int currentLanguagesCount);
}
