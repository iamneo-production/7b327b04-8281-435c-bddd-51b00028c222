package com.examly.springapp.exceptions;

public class EmailNotUpdatableException extends Exception{
    public EmailNotUpdatableException() {
    }

    public EmailNotUpdatableException(String message) {
        super(message);
    }
}
