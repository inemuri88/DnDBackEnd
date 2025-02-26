package it.dnd.game_elements_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TalentDTO {

    private Long id;
    private String name;
    private String description;
    private List<String> prerequisites;
    private String benefits;

}
