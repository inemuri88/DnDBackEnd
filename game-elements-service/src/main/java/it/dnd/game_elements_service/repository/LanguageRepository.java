package it.dnd.game_elements_service.repository;

import it.dnd.game_elements_service.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
