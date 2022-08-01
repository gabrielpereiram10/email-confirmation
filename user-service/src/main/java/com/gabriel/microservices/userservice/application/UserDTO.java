package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.domain.User;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;
import com.gabriel.microservices.userservice.domain.valueObjects.Password;

public class UserDTO {

    private String username, email, password;
    public UserDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    protected User buildEntity() {
        return new User(username, new Email(email), new Password(password));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
