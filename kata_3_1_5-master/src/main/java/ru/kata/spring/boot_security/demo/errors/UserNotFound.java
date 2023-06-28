package ru.kata.spring.boot_security.demo.errors;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
}
