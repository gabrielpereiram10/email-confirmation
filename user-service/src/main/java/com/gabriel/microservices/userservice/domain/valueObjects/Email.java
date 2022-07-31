package com.gabriel.microservices.userservice.domain.valueObjects;

import com.gabriel.microservices.userservice.domain.exceptions.InvalidFieldException;

public class Email {

    private final String value;
    public Email(String email) {
        if (!email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidFieldException("email", "Email inválido.");
        }

        this.value = email;
    }

    public String getValue() {
        return value;
    }
}