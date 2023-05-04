package com.codecool.elproyectegrande1.exceptions;

public class DreamNotFoundException extends RuntimeException {

    public DreamNotFoundException(Long id) {
        super("Dream with id " + id + " not found");
    }
}
