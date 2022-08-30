package com.example.assignment3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(int id) {
        super("Student does not exist with ID: " + id);
    }
    public MovieNotFoundException(String message) {
        super(message);
    }
    public MovieNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public MovieNotFoundException(Throwable cause) {
        super(cause);
    }
    public MovieNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
