package it.dnd.game_elements_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveLanguageDTO {
    private String name;
    private String description;
    private String alphabet;
    private boolean isSecret;
}