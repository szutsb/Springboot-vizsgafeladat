package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchEsrbException extends RuntimeException {
    public NoSuchEsrbException(String message) {
        super(message);
    }

    public NoSuchEsrbException(String message, Throwable cause) {
        super(message, cause);
    }
}

