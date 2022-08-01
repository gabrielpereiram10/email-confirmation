package com.gabriel.microservices.userservice.application;

public class UserAlreadyExistsException extends RuntimeException {

    private final String property;
    public UserAlreadyExistsException(String property, String message) {
        super(message);
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
