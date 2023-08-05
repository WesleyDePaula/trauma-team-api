package nc.traumateam.api.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerImpl {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handle404Error(EntityNotFoundException ex) {
        System.out.println(ex.getMessage()); //TODO: tratar mensagem especifico para cada entidade. TESTAR HERANÇA DAS EXCEÇÕES
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handle400Error(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(Errors::new).collect(Collectors.toList()));
    }

    private record Errors(String field, String message) {
        public Errors(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
