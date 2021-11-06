package com.db.task.dbclm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class DbClmControllerAdvice {

    @ExceptionHandler({InvalidNaceDataException.class, IllegalArgumentException.class})
    public final ResponseEntity<ApiError> handleInvalidNaceException(Exception ex, WebRequest request) {
        ApiError body = new ApiError(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        ApiError body = new ApiError(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
