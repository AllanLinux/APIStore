package com.allan.APIStore.resources.exception;

import com.allan.APIStore.services.exceptions.DatabaseException;
import com.allan.APIStore.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

// Anotação que irá interceptar as excessões que acontecerem para que este objeto
// possa executar um possível tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

    // Esse metodo irá interceptar qqr excessão do tipo "ResourceNotFoundException" que for lançada e irá fazer o tratamento
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // Esse metodo irá interceptar qqr excessão do tipo "ResourceNotFoundException" que for lançada e irá fazer o tratamento
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
