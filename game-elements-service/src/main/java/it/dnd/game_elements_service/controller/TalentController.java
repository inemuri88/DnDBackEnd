package it.dnd.game_elements_service.controller;


import it.dnd.game_elements_service.dto.ResponseHandler;
import it.dnd.game_elements_service.dto.TalentDTO;
import it.dnd.game_elements_service.dto.request.SaveTalentDTO;
import it.dnd.game_elements_service.exception.TalentException;
import it.dnd.game_elements_service.service.TalentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/talents")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TalentController {


    private final TalentService talentService;

    @GetMapping("/get-talent")
    public ResponseEntity<Object> getTalent(@RequestParam Long id) {
        return ResponseHandler.generateResponse(HttpStatus.OK, talentService.getTalent(id)) ;
    }

    @GetMapping("/get-all-talents")
    public ResponseEntity<Object> getAllTalents() {
        return ResponseHandler.generateResponse(HttpStatus.OK,talentService.getAllTalents());
    }

    //sbagliato il getMapping
    @GetMapping("/has-talent-pre")
    public ResponseEntity<Object> hasTalentPrerequisite(@RequestBody TalentDTO dto) throws TalentException {
        return ResponseHandler.generateResponse(HttpStatus.OK, talentService.hasTalentAsPrerequisite(dto));
    }

    @PostMapping("save-talent")
    public ResponseEntity<Object> saveTalent(@RequestBody SaveTalentDTO saveDto) {
        return ResponseHandler.generateResponse(HttpStatus.CREATED, talentService.saveTalent(saveDto));
    }
}