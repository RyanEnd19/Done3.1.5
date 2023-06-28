package ru.kata.spring.boot_security.demo.advice_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kata.spring.boot_security.demo.errors.ErrorRespond;
import ru.kata.spring.boot_security.demo.errors.UserNotCreated;
import ru.kata.spring.boot_security.demo.errors.UserNotFound;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorRespond> responseEntityNotFound() {
        return new ResponseEntity<>(
                new ErrorRespond("not found", System.currentTimeMillis() / 1000),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotCreated.class)
    public ResponseEntity<ErrorRespond> responseEntityNotCreated() {
        return new ResponseEntity<>(
                new ErrorRespond("not created", System.currentTimeMillis() / 1000),
                HttpStatus.BAD_REQUEST);
    }
}
