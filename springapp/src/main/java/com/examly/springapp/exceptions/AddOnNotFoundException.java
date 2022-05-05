package com.examly.springapp.exceptions;
import lombok.NoArgsConstructor;

public class AddOnNotFoundException extends Exception
{
	public AddOnNotFoundException() {
    }
	
	public AddOnNotFoundException(String message) {
        super(message);
    }
}
