package it.dnd.game_elements_service.service;

import it.dnd.game_elements_service.dto.request.SaveCharacterClassDTO;

import it.dnd.game_elements_service.exception.CharacterClassException;
import it.dnd.game_elements_service.exception.TalentException;
import it.dnd.game_elements_service.mapper.CharacterClassMapper;
import it.dnd.game_elements_service.model.CharacterClass;
import it.dnd.game_elements_service.repository.CharacterClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterClassServiceImpl implements CharacterClassService{

    private final CharacterClassRepository characterClassRepository;
    private final CharacterClassMapper characterClassMapper;

    @Override
    public SaveCharacterClassDTO saveClass(SaveCharacterClassDTO saveCharacterClassDTO) {
        if (characterClassRepository.existsByName(saveCharacterClassDTO.getName())) {
            throw new IllegalArgumentException("Character class already exists");
        }
        CharacterClass characterClass = characterClassMapper.toModel(saveCharacterClassDTO);

        try{
          return characterClassMapper.toSaveDTO(characterClassRepository.save(characterClass)) ;
        }catch (DataAccessException dae){
            throw new CharacterClassException("Errore di accesso al database", dae);
        }
    }


}
