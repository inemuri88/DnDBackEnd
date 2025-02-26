package it.dnd.game_elements_service.service;

import it.dnd.game_elements_service.dto.SpellDTO;
import it.dnd.game_elements_service.dto.request.SaveSpellDTO;
import it.dnd.game_elements_service.exception.ResourceNotFoundException;
import it.dnd.game_elements_service.mapper.SpellMapper;
import it.dnd.game_elements_service.model.Spell;
import it.dnd.game_elements_service.repository.SpellRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@RequiredArgsConstructor
public class SpellServiceImpl implements SpellService {

    private final SpellRepository spellRepository;
    private final SpellMapper spellMapper;

    @Cacheable("spell")
    @Transactional(readOnly = true)
    public SpellDTO getSpell(Long id) {
        return spellRepository.findById(id)
                .map(spellMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Spell not found with id: " + id));
    }

    @Cacheable("allSpells")
    @Transactional(readOnly = true)
    public List<SpellDTO> getAllSpell() {
        List<Spell> spells = spellRepository.findAll();
        return spellMapper.toDtos(spells);
    }

    @CacheEvict(value = {"spell", "allSpell"}, allEntries = true)
    @Transactional
    public SaveSpellDTO saveSpell(@Valid SaveSpellDTO saveSpellDto) {
        return saveSingleSpell(saveSpellDto);
    }

    private SaveSpellDTO saveSingleSpell(SaveSpellDTO saveSpellDto) {
        Spell spell = spellMapper.toModel(saveSpellDto);
        Spell savedSpell = spellRepository.save(spell);
        return spellMapper.toSaveDto(savedSpell);
    }

    @Transactional
    @CacheEvict(value = {"spell", "allSpells"}, allEntries = true)
    public void deleteSpell(Long id) {
        try {
            deletingSpell(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Cannot delete spell due to existing references: " + e.getMessage());
        }
    }

    private void deletingSpell(Long id) {
        Spell spell = spellRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Spell not found with id: " + id));

        // Verifica se ci sono relazioni che impediscono l'eliminazione
        if (!spell.getClasses().isEmpty()) {
            throw new DataIntegrityViolationException("Cannot delete spell: still associated with classes");
        }
        spellRepository.delete(spell);
    }



}
