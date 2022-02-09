package com.examly.springapp.exceptions;

public class EmailTakenException extends Exception{
    public EmailTakenException() {
    }

    public EmailTakenException(String message) {
        super(message);
    }
}
