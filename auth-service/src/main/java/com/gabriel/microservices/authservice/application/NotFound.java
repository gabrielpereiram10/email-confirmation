package com.gabriel.microservices.authservice.application;

public class NotFound extends RuntimeException {

    public NotFound() {
    }

    public NotFound(String message) {
        super(message);
    }
}
