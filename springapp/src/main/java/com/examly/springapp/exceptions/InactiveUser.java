package com.examly.springapp.exceptions;

public class InactiveUser extends Exception{
    public InactiveUser() {
    }

    public InactiveUser(String message) {
        super(message);
    }
}
