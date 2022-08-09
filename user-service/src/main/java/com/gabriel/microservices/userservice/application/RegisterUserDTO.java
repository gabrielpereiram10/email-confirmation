package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.domain.User;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;

public class RegisterUserDTO {

    private String name, email, password, confirmationPassword;
    public RegisterUserDTO(String name, String email, String password, String confirmationPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmationPassword = confirmationPassword;
    }

    protected User buildEntity() {
        return new User(name, new Email(email));
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
