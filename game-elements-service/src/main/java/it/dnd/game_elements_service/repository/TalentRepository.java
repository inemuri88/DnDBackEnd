package it.dnd.game_elements_service.repository;

import it.dnd.game_elements_service.model.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TalentRepository extends JpaRepository<Talent, Long> {
    Talent findTalentByName(String name);
}
