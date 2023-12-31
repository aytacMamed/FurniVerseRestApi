package com.example.furniverse.exception;

import com.example.furniverse.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class CustomizedException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public final ResponseEntity<Object> handleCategoryNotFound(CategoryNotFoundException ex, WebRequest request) throws Exception {
        ErrorDetails categoryErrorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
        log.error("category not found");

        return new ResponseEntity<>(categoryErrorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
