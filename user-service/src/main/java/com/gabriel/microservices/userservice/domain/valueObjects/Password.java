package com.gabriel.microservices.userservice.domain.valueObjects;

import com.gabriel.microservices.userservice.domain.InvalidFieldException;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Objects.equals(value, password.value);
    }

    public String getValue() {
        return value;
    }
}
