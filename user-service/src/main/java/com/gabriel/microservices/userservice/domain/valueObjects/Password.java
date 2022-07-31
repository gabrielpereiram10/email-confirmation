package com.gabriel.microservices.userservice.domain.valueObjects;

import com.gabriel.microservices.userservice.domain.exceptions.InvalidFieldException;

public class Password {

    private final String value;
    public Password(String password) {
        String field = "senha";
        String baseMessage = "Senha deve conter pelo menos";
        if (password.length() < 6) {
            throw new InvalidFieldException(field, baseMessage + " 6 caracteres.");
        }

        if (!password.matches("^.*[A-Z]+.*$")) {
            throw new InvalidFieldException(field, baseMessage + " uma letra maiúscula.");
        }

        if (!password.matches("^.*[a-z]+.*$")) {
            throw new InvalidFieldException(field, baseMessage + " uma letra minúscula.");
        }

        this.value = password;
    }

    public String getValue() {
        return value;
    }
}
