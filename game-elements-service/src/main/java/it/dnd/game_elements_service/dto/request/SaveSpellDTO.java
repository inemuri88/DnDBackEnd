package it.dnd.game_elements_service.dto.request;

import it.dnd.game_elements_service.model.CharacterClass;
import it.dnd.game_elements_service.model.enumerated.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveSpellDTO {
    private String name;
    private String description;
    private List<CharacterClass> classes;
    private int level;
    private String castingTime;
    private String range;
    private String duration;
    private String components;
    private School school;
    private boolean concentration;
}
