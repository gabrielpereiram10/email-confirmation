package com.gabriel.microservices.authservice.application;

public class UserDTO {
    private String email, password;
    private UserState state;

    public UserDTO(String email, String password, UserState state) {
        this(email, password);
        this.state = state;
    }

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
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

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }
}
