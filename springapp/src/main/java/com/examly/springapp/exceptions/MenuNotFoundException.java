package com.examly.springapp.exceptions;

public class MenuNotFoundException extends Exception {

    public MenuNotFoundException() {
    }

    public MenuNotFoundException(String message) {
        super(message);
    }
}
