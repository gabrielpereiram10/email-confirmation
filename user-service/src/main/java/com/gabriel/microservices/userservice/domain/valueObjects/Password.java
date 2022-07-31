package com.gabriel.microservices.userservice.domain.valueObjects;

import com.gabriel.microservices.userservice.domain.exceptions.InvalidFieldException;

public class Password {

    private final String value;
    public Password(String password) {
        if (password.length() < 6) {
            throw new InvalidFieldException("senha", "Senha deve conter pelo menos 6 caracteres.");
        }

        this.value = password;
    }

    public String getValue() {
        return value;
    }
}
