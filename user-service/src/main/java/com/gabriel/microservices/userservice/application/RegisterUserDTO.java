package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.domain.User;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;
import com.gabriel.microservices.userservice.domain.valueObjects.Password;

public class RegisterUserDTO {

    private String name, email;
    private Password password, confirmationPassword;
    public RegisterUserDTO(String name, String email, String password, String confirmationPassword) {
        this.name = name;
        this.email = email;
        this.password = new Password(password);
        this.confirmationPassword = new Password(confirmationPassword);
    }

    User buildEntity() {
        return new User(name, new Email(email));
    }

    public Password getConfirmationPassword() {
        return confirmationPassword;
    }

    public void setConfirmationPassword(Password confirmationPassword) {
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

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
