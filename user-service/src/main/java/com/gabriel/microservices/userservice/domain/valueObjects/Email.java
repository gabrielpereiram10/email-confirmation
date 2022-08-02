package com.gabriel.microservices.userservice.domain.valueObjects;

import com.gabriel.microservices.userservice.domain.InvalidFieldException;

import java.util.Objects;

public class Email {

    private final String value;
    public Email(String email) {
        if (!email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidFieldException("email", "Email inválido.");
        }

        this.value = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    public String getValue() {
        return value;
    }
}
