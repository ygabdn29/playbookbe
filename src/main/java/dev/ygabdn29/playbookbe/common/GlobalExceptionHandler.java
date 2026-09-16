package dev.ygabdn29.playbookbe.common;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.ygabdn29.playbookbe.common.utils.Utils;

@ControllerAdvice
public class GlobalExceptionHandler {
  // This class can be used to handle exceptions globally and return appropriate
  // responses.
  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex) {
    return Utils.generateResponse(HttpStatus.UNAUTHORIZED, "Invalid username or password", null);
  }

  @ExceptionHandler(UsernameNotFoundException.class)
  public ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex) {
    return Utils.generateResponse(HttpStatus.UNAUTHORIZED, "Invalid username or password", null);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getDefaultMessage())
        .collect(Collectors.toList());
    return Utils.generateResponse(HttpStatus.BAD_REQUEST, "Invalid request", errors);
  }
}