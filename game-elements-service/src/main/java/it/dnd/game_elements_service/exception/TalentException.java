package it.dnd.game_elements_service.exception;

public class TalentException extends RuntimeException {
    public TalentException(String message) {
        super(message);
    }

    public TalentException(String message, Throwable cause) {
        super(message, cause);
    }
}