package cursoSpringBoot.error;

import cursoSpringBoot.error.pojo.ErrorDetails;
import cursoSpringBoot.exceptions.DeleteEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // Permite una gestion global de las excepciones.
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleEntityNotFoundException(EntityNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());

        System.out.println(ex.getMessage());

        return errorResponse;
    }

    @ExceptionHandler(DeleteEntityNotFoundException.class) // Captura la excepcion DeleteEntityNotFoundException, es una
    // es una excepcion personalizada.
    public ResponseEntity<?> handleUserNotFoundException(DeleteEntityNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}

