package com.codecool.elproyectegrande1.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}