package br.com.dnos.Ponto.config;

import br.com.dnos.Ponto.exception.EmailUsedException;
import br.com.dnos.Ponto.exception.UsernameOrPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AplicationControllerAdvice {

    @ExceptionHandler(UsernameOrPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleUsernameOrPasswordException(UsernameOrPasswordException exception) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Email ou senha inválida");
        return errorResponse;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            errors.put(((FieldError) error).getField(), error.getDefaultMessage());
        });

        return errors;
    }

    @ExceptionHandler(EmailUsedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleEmailUsedException(EmailUsedException exception) {

        Map<String, String> error = new HashMap<>();
        error.put("exist-email", exception.getMessage());

        return error;
    }
}
