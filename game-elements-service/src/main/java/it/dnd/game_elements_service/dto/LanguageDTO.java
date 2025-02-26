package it.dnd.game_elements_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {
    private Long id;
    private String name;
    private String description;
    private String alphabet;
    private boolean isSecret;
    private Set<Long> automaticRaceIds;
    private Set<Long> bonusRaceIds;
}