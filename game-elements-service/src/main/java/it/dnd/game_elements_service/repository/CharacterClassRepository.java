package it.dnd.game_elements_service.repository;

import it.dnd.game_elements_service.model.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long> {
}