package com.db.task.dbclm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@ControllerAdvice
public class DbClmControllerAdvice {

    @ExceptionHandler({InvalidNaceDataException.class, IllegalArgumentException.class})
    public final ResponseEntity<ApiError> handleInvalidNaceException(Exception ex, WebRequest request) {
        var body = new ApiError(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NaceDataNotFoundException.class})
    public final ResponseEntity<ApiError> handleNoDataFoundException(Exception ex, WebRequest request) {
        var body = new ApiError(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        var body = new ApiError(LocalDateTime.now(), ex.getMessage());
        if (ex instanceof MethodArgumentTypeMismatchException) {
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
