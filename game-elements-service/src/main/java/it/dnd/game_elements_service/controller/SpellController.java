package it.dnd.game_elements_service.controller;

import it.dnd.game_elements_service.dto.ResponseHandler;
import it.dnd.game_elements_service.dto.request.SaveSpellDTO;
import it.dnd.game_elements_service.exception.ResourceNotFoundException;
import it.dnd.game_elements_service.service.SpellService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spell")
@RequiredArgsConstructor
public class SpellController {

    public final SpellService spellService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSpell(@PathVariable Long id) {
        return ResponseHandler.generateResponse(HttpStatus.OK, spellService.getSpell(id));
    }

    @GetMapping
    public ResponseEntity<Object> getAllSpell() {
        return ResponseHandler.generateResponse(HttpStatus.OK, spellService.getAllSpell());
    }

    @PostMapping
    public ResponseEntity<Object> saveSpell(@RequestBody SaveSpellDTO saveSpellDTO) {
        return ResponseHandler.generateResponse(HttpStatus.CREATED, spellService.saveSpell(saveSpellDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSpell(@PathVariable Long id) {
        try {
            spellService.deleteSpell(id);
            return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT, null);
        } catch (ResourceNotFoundException e) {
            return ResponseHandler.generateErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            return ResponseHandler.generateErrorResponse(HttpStatus.CONFLICT, e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.generateErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "An unexpected error occurred while deleting the spell"
            );
        }
    }


}
