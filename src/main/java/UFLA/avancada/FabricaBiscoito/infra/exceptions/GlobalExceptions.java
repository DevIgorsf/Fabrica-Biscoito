package UFLA.avancada.FabricaBiscoito.infra.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundHandlerMethod(EntityNotFoundException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), 404, "Not Found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

    @ExceptionHandler(DuplicatedEntityException.class)
    public ResponseEntity<StandardError> entityNotFoundHandlerMethod(DuplicatedEntityException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), 409, "Conflict", e.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(se);
    }

    @ExceptionHandler(CustomAuthenticationException.class)
    public ResponseEntity<StandardError> entityNotFoundHandlerMethod(CustomAuthenticationException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), 401, "Unauthorized", e.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(se);
    }

    @ExceptionHandler(NullObjectException.class)
    public ResponseEntity<StandardError> entityNotFoundHandlerMethod(NullObjectException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), 400, "Bad Request", e.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> HttpMessageNotReadableHandlerMethod(HttpMessageNotReadableException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), 400, "Bad Request", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<StandardError> InvalidFormatHandlerMethod(InvalidFormatException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), 400, "Bad Request", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> MethodArgumentNotValidHandlerMethod(MethodArgumentNotValidException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), 400, "Bad Request", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<StandardError> SQLIntegrityConstraintViolationExceptionHandlerMethod(SQLIntegrityConstraintViolationException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), 500, "Internal Server Error", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(se);
    }
}
