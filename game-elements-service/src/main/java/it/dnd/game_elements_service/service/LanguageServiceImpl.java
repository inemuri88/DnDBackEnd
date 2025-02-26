package it.dnd.game_elements_service.service;

import it.dnd.game_elements_service.dto.LanguageDTO;
import it.dnd.game_elements_service.dto.request.SaveLanguageDTO;
import it.dnd.game_elements_service.model.Language;
import it.dnd.game_elements_service.model.Race;
import it.dnd.game_elements_service.repository.LanguageRepository;
import it.dnd.game_elements_service.repository.RaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService{

    private final LanguageRepository languageRepository;
    private final RaceRepository raceRepository;

    @Override
    public LanguageDTO getLanguage(Long id) {
        return null;
    }

    @Override
    public List<LanguageDTO> getAllLanguages() {
        return List.of();
    }

    @Override
    public SaveLanguageDTO saveLanguage(SaveLanguageDTO languageDTO) {
        return null;
    }

    @Override
    public void deleteLanguage(Long id) {

    }

    public boolean isAutomaticLanguage(Language language, Race race) {
        return language.getRacesWithAutomatic().contains(race);
    }

    public boolean isBonusLanguage(Language language, Race race) {
        return language.getRacesWithBonus().contains(race);
    }

    public boolean hasAvailableLanguageSlots(Race race, int currentLanguagesCount) {
        // La logica per calcolare gli slot disponibili
        int maxBonusLanguages = calculateMaxBonusLanguages(race);
        return currentLanguagesCount < maxBonusLanguages;
    }

    private int calculateMaxBonusLanguages(Race race) {
        // Esempio: il numero di lingue bonus potrebbe essere basato
        // sul modificatore di Intelligenza della razza
        return race.getIntelligenceModifier() > 0 ? race.getIntelligenceModifier() : 0;
    }

    public boolean isValidLanguageChoice(Race race, Language language, int currentLanguagesCount) {
        return isAutomaticLanguage(language, race) ||
                (isBonusLanguage(language, race) && hasAvailableLanguageSlots(race, currentLanguagesCount));
    }

    /*
    Possibili utilizzi dei due metodi:
    1)  Durante la creazione del personaggio:
        Immagina di avere un sistema che aiuta i giocatori a creare i loro personaggi.
        Quando un giocatore sceglie una razza, potresti voler mostrare quali lingue sono automatiche e quali sono bonus.

        Language commonLanguage = languageRepository.findByName("Common");
        Race elf = raceRepository.findByName("Elf");

        if (commonLanguage.isAutomaticFor(elf)) {
            System.out.println("Common è una lingua automatica per gli elfi");
        }

    2)  Validazione delle scelte dei giocatori:
        Quando un giocatore sta selezionando le lingue per il suo personaggio,
        puoi usare questi metodi per verificare se le scelte sono valide

        public boolean isValidLanguageChoice(Character character, Language language) {
            Race characterRace = character.getRace();
            return language.isAutomaticFor(characterRace) ||
                   (language.isBonusFor(characterRace) && character.hasAvailableLanguageSlots());
        }
    */
}
