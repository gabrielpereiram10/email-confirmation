package com.gabriel.microservices.userservice.domain;

import com.gabriel.microservices.userservice.application.UserDTO;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;
import com.gabriel.microservices.userservice.domain.valueObjects.Password;

public class User {
    private String username;
    private Email email;
    private Password password;

    public User(String username, Email email, Password password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        User anotherUser = (User) obj;
        return email.equals(anotherUser.email) || username.equals(anotherUser.username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPassword(Password password) {
        this.password = password;
    }
}
