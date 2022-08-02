package com.gabriel.microservices.userservice.domain;

public class InvalidFieldException extends RuntimeException {

    private final String filed;

    public InvalidFieldException(String filed, String message) {
        super(message);
        this.filed = filed;
    }

    public String getFiled() {
        return filed;
    }
}
