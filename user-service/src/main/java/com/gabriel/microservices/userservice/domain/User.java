package com.gabriel.microservices.userservice.domain;

import com.gabriel.microservices.userservice.domain.valueObjects.Email;
import com.gabriel.microservices.userservice.domain.valueObjects.Password;

import java.util.Objects;

public class User {
    private String name;
    private Email email;
    private Password password;

    public User(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public void confirmPassword(Password hashedPassword, Password password, Password confirmationPassword) {
        if (!password.equals(confirmationPassword)) {
            throw new InvalidFieldException("password", "Senhas não conferem.");
        }

        this.password = hashedPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }
}
