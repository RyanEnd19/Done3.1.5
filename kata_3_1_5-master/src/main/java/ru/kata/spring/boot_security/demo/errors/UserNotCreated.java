package ru.kata.spring.boot_security.demo.errors;

public class UserNotCreated extends RuntimeException{
    public UserNotCreated(String msg){
        super(msg);
    }
}
