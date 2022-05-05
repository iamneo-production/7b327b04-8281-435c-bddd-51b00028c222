package com.examly.springapp.exceptions;

public class ThemeNotFoundException extends Exception {

    public ThemeNotFoundException() {
    }

    public ThemeNotFoundException(String message) {
        super(message);
    }
}
