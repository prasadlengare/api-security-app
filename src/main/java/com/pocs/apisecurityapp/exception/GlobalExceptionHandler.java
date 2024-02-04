package com.pocs.apisecurityapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.zip.DataFormatException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleExceptionRuntimeException(RuntimeException ex) {
        // Handle exception type 1
        return new ResponseEntity<>("Runtime Exception Type 1: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataFormatException.class)
    public ResponseEntity<String> handleExceptionDataFormatException(DataFormatException ex) {
        // Handle exception type 2
        return new ResponseEntity<>("Data FormatException Type 2: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Add more exception handlers for other exception types as needed

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        // Handle any other exceptions that are not explicitly handled
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
