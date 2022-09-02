package com.example.assignment3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FranchiseNotFoundException extends RuntimeException {
    public FranchiseNotFoundException(int id) {
        super("Franchise does not exist with ID: " + id);
    }

    public FranchiseNotFoundException(String message) {
        super(message);
    }

    public FranchiseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FranchiseNotFoundException(Throwable cause) {
        super(cause);
    }

    public FranchiseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
