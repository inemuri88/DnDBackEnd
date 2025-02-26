package it.dnd.game_elements_service.dto;



import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    /**
     * Generates a response entity with the given status and data.
     *
     * @param status the HTTP status of the response
     * @param data the data to be included in the response
     * @return a response entity containing the data and status
     */
    public static ResponseEntity<Object> generateResponse(@NotNull HttpStatus status, Object data) {
        // Create a map to store the data and status
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", data);
        map.put("status", status.value());

        // Return a new ResponseEntity containing the map and status
        return new ResponseEntity<Object>(map, status);
    }

    /**
     * Generate an error response with the given HTTP status code.
     *
     * @param status the HTTP status code
     * @return the ResponseEntity containing the error response
     */
    public static ResponseEntity<Object> generateErrorResponse(@NotNull HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", status.getReasonPhrase());
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

    /**
     * Generate an error response with the specified status and message.
     * @param status the HTTP status code
     * @param message the error message
     * @return the ResponseEntity containing the error response
     */
    public static ResponseEntity<Object> generateErrorResponse(@NotNull HttpStatus status, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", status.getReasonPhrase());
        map.put("message", message);
        map.put("status", status.value());

        return new ResponseEntity<>(map, status);
    }

    /**
     * Generates an error response with the specified status and fields.
     *
     * @param status the HTTP status
     * @param fields the fields associated with the error
     * @return the ResponseEntity containing the error response
     */
    public static ResponseEntity<Object> generateErrorResponse(@NotNull HttpStatus status, Map<String, String> fields) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", status.getReasonPhrase());
        map.put("fields", fields);
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

}