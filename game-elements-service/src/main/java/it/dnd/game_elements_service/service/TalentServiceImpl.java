package it.dnd.game_elements_service.service;

import it.dnd.game_elements_service.dto.TalentDTO;
import it.dnd.game_elements_service.dto.request.SaveTalentDTO;
import it.dnd.game_elements_service.exception.ResourceNotFoundException;
import it.dnd.game_elements_service.exception.TalentException;
import it.dnd.game_elements_service.mapper.TalentMapper;
import it.dnd.game_elements_service.model.Talent;
import it.dnd.game_elements_service.repository.TalentRepository;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.hibernate.MappingException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class TalentServiceImpl implements  TalentService{

    private final TalentRepository talentRepository;
    private final TalentMapper talentMapper;

    @Cacheable("talent")
    @Transactional(readOnly = true)
    public TalentDTO getTalent(Long id) {
        return talentMapper.toDto(talentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talent not found")));
    }

    @Cacheable("allTalents")
    @Transactional(readOnly = true)
    public List<TalentDTO> getAllTalents() {
        return talentMapper.toDtos(talentRepository.findAll());
    }

    @CacheEvict(value = {"talent", "allTalents"}, allEntries = true)
    @Transactional
    public SaveTalentDTO saveTalent(@Valid SaveTalentDTO saveTalentDto) throws DataIntegrityViolationException, ValidationException {
        try {
            return saveSingleTalent(saveTalentDto);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Could not save talent: " + e.getMessage());
        }
    }

    private SaveTalentDTO saveSingleTalent(SaveTalentDTO saveTalentDto){
        String existTalent = talentRepository.findTalentByName(saveTalentDto.getName()).getName();
        if(existTalent.isEmpty()){
            return talentMapper.toSaveDto(talentRepository.save(talentMapper.toModel(saveTalentDto))) ;
        }
        return null;
    }

    @Transactional(readOnly = true)
    public boolean hasTalentAsPrerequisite (TalentDTO talentDto) throws TalentException {
        try {
            if (!talentMapper.toModel(talentDto).getPrerequisites().isEmpty())
               return checkTalentPrerequisite(talentDto);
        } catch (DataAccessException dae) {
            throw new TalentException("Errore di accesso al database durante la ricerca dei prerequisiti!", dae);
        } catch (MappingException me) {
            throw new TalentException("Errore durante la mappatura del talentDTO!", me);
        }
        return false;
    }

    public boolean checkTalentPrerequisite(TalentDTO talentDto){
        for (String prerequisite : talentDto.getPrerequisites()) {
            Talent result = talentRepository.findTalentByName(prerequisite);

            // Se trovi un prerequisito che esiste, restituisci subito true
            if (result != null) {
                return true;
            }
        }
        return false;
    }

    //TODO: sistemare il conflitto dei duplicati in sql
}

