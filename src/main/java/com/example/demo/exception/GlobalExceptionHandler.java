package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        log.info("There is no data in the file {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("В файле нет данных");
    }

    @ExceptionHandler(FileReadException.class)
    public ResponseEntity<String> handleFileReadException(FileReadException e) {
        log.error("Failed to read file {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Не удалось прочитать данные из файла");
    }

    @ExceptionHandler(FileWriteException.class)
    public ResponseEntity<String> handleFileWriteException(FileWriteException e) {
        log.error("Failed to write file {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Не удалось записать данные в файл");
    }

}

