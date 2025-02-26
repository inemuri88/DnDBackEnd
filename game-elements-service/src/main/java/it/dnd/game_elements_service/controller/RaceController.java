package it.dnd.game_elements_service.controller;


import it.dnd.game_elements_service.dto.RaceDTO;
import it.dnd.game_elements_service.dto.ResponseHandler;
import it.dnd.game_elements_service.dto.request.SaveRaceDTO;
import it.dnd.game_elements_service.service.RaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/races")
@RequiredArgsConstructor
public class RaceController {

    private final RaceService raceService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRace(@PathVariable Long id) {
        return ResponseHandler.generateResponse(HttpStatus.OK, raceService.getRace(id));
    }

    @GetMapping
    public ResponseEntity<Object> getAllRaces() {
        return ResponseHandler.generateResponse(HttpStatus.OK, raceService.getAllRaces());
    }

    @PostMapping
    public ResponseEntity<Object> saveRace(@RequestBody SaveRaceDTO saveRaceDTO) {
        SaveRaceDTO savedRace = raceService.saveRace(saveRaceDTO);
        return ResponseHandler.generateResponse(HttpStatus.CREATED, savedRace);
    }

    @PatchMapping
    public ResponseEntity<Object> updateRace(@RequestBody RaceDTO raceDTO) {
        RaceDTO updatedRace = raceService.updateRace(raceDTO);
        return ResponseHandler.generateResponse(HttpStatus.OK, updatedRace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRace(@PathVariable Long id) {
        raceService.deleteRace(id);
        return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT, null);
    }
}
