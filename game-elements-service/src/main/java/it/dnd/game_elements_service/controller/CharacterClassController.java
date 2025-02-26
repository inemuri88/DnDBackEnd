package it.dnd.game_elements_service.controller;

import it.dnd.game_elements_service.dto.ResponseHandler;
import it.dnd.game_elements_service.dto.request.SaveCharacterClassDTO;
import it.dnd.game_elements_service.service.CharacterClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/character-class")
@RequiredArgsConstructor
public class CharacterClassController {

    private final CharacterClassService characterClassService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveCharacterClass(@RequestBody SaveCharacterClassDTO saveCharacterClassDTO){
        return ResponseHandler.generateResponse(HttpStatus.CREATED, characterClassService.saveClass(saveCharacterClassDTO));
    }
}
