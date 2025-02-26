package it.dnd.game_elements_service.repository;


import it.dnd.game_elements_service.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellRepository extends JpaRepository<Spell, Long> {

}
