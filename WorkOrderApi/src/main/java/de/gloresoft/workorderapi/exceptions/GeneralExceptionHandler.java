package de.gloresoft.workorderapi.exceptions;

import de.gloresoft.workorderapi.constants.ErrorCodes;
import de.gloresoft.workorderapi.entities.ErrorMessageEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException e) {
        ErrorMessageEntity errorMessageEntity = new ErrorMessageEntity(e.getMessage(), "",
                ZonedDateTime.now(ZoneId.of("Z")), ErrorCodes.RESOURCE_NOT_FOUND);
        return new ResponseEntity<>(errorMessageEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<Object> handleNumberNotFound(NumberFormatException e) {
        ErrorMessageEntity errorMessageEntity = new ErrorMessageEntity(e.getMessage(), "The given id is not in a numeric format",
                ZonedDateTime.now(ZoneId.of("Z")), ErrorCodes.INCORRECT_NUMBER_FORMAT);
        return new ResponseEntity<>(errorMessageEntity, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ResourceAlreadyExistsException.class})
    public ResponseEntity<Object> handleResourceAlreadyExists(ResourceAlreadyExistsException e) {
        ErrorMessageEntity errorMessageEntity = new ErrorMessageEntity(e.getMessage(), "The resource with the given id already exists. Please use a new id",
                ZonedDateTime.now(ZoneId.of("Z")), ErrorCodes.RESOURCE_ALREADY_EXISTS);
        return new ResponseEntity<>(errorMessageEntity, HttpStatus.BAD_REQUEST);
    }
}
