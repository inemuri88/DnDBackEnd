package it.dnd.game_elements_service.service;


import it.dnd.game_elements_service.dto.RaceDTO;
import it.dnd.game_elements_service.dto.request.SaveRaceDTO;
import it.dnd.game_elements_service.exception.RaceException;
import it.dnd.game_elements_service.mapper.RaceMapper;
import it.dnd.game_elements_service.model.CharacterClass;
import it.dnd.game_elements_service.model.Language;
import it.dnd.game_elements_service.model.Race;
import it.dnd.game_elements_service.repository.CharacterClassRepository;
import it.dnd.game_elements_service.repository.LanguageRepository;
import it.dnd.game_elements_service.repository.RaceRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.beans.PropertyDescriptor;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RaceServiceImpl implements RaceService {

    private final RaceMapper raceMapper;
    private final RaceRepository raceRepository;
    private final CharacterClassRepository characterClassRepository;
    private final LanguageRepository languageRepository;

    @Override
    @Cacheable("races")
    public RaceDTO getRace(Long id) {
        return raceMapper.toDTO(raceRepository.findById(id).orElse(null));
    }

    @Override
    @Cacheable("allRaces")
    public List<RaceDTO> getAllRaces() {
        return raceMapper.toDTOs(raceRepository.findAll());
    }

    @Override
    @CacheEvict(value = {"allRaces","races"}, allEntries = true)
    @Transactional
    public SaveRaceDTO saveRace(SaveRaceDTO raceDto) throws RaceException {
        Race race = raceMapper.toModel(raceDto);
        Race savedRace = raceRepository.save(race);
        return raceMapper.toSaveDTO(savedRace);
    }

    @Override
    public void deleteRace(Long id) {
        raceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public RaceDTO updateRace(RaceDTO raceDto) {
        if (raceDto.getId() == null) {
            throw new IllegalArgumentException("Race ID must not be null for updating.");
        }

        Race race = raceRepository.findById(raceDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Race not found with ID: " + raceDto.getId()));

        // Copia solo le proprietà non nulle
        BeanUtils.copyProperties(raceDto, race, getNullPropertyNames(raceDto));

        // Gestisci le associazioni separatamente
        updateFavoredClass(raceDto, race);
        updateLanguages(raceDto, race);

        Race updatedRace = raceRepository.save(race);

        return raceMapper.toDTO(updatedRace);
    }

    private void updateFavoredClass(RaceDTO raceDto, Race race) {
        if (raceDto.getFavoredClassId() != null) {
            CharacterClass favoredClass = characterClassRepository.findById(raceDto.getFavoredClassId())
                    .orElseThrow(() -> new EntityNotFoundException("Favored Class not found with ID: " + raceDto.getFavoredClassId()));
            race.setFavoredClass(favoredClass);
        }
    }

    private void updateLanguages(RaceDTO raceDto, Race race) {
        if (raceDto.getLanguageIds() != null) {
            Set<Language> languages = new HashSet<>(languageRepository.findAllById(raceDto.getLanguageIds()));
            race.setLanguages(languages);
        }

        if (raceDto.getAutomaticLanguageIds() != null) {
            Set<Language> automaticLanguages = new HashSet<>(languageRepository.findAllById(raceDto.getAutomaticLanguageIds()));
            race.setAutomaticLanguages(automaticLanguages);
        }

        if (raceDto.getBonusLanguageIds() != null) {
            Set<Language> bonusLanguages = new HashSet<>(languageRepository.findAllById(raceDto.getBonusLanguageIds()));
            race.setBonusLanguages(bonusLanguages);
        }
    }

    private String[] getNullPropertyNames(Object source) {
        final var wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(PropertyDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

    //TODO: Da inserire in tutte le classi che nei salvataggi venga inserito tutto in capitalize e che i nomi siano Unique

    //TODO: sistemare anche le exception custom per ogni classe, tipo talent, spell ecc
}
