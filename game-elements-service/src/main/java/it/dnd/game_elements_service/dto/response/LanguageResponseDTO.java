package it.dnd.game_elements_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String alphabet;
    private boolean isSecret;
    private int automaticRacesCount;
    private int bonusRacesCount;
}