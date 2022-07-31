package com.gabriel.microservices.userservice.domain.valueObjects;

import com.gabriel.microservices.userservice.domain.exceptions.InvalidFieldException;

public class Email {

    private final String value;
    public Email(String email) {
        throw new InvalidFieldException("email", "Email inválido.");
    }

    public String getValue() {
        return value;
    }
}
