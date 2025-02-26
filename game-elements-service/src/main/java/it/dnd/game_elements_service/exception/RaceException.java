package it.dnd.game_elements_service.exception;

public class RaceException extends RuntimeException {
    public RaceException(String message) {
        super(message);
    }

    public RaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
