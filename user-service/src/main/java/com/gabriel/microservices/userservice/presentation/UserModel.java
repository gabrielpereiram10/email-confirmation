package com.gabriel.microservices.userservice.presentation;

import javax.persistence.*;

@Entity(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String confirmationEmailToken;

    public UserModel() {
    }

    public UserModel(String name, String email, String password, String confirmationEmailToken) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmationEmailToken = confirmationEmailToken;
    }

    public UserModel(Long id, String name, String email, String password, String confirmationEmailToken) {
        this(name, email, password, confirmationEmailToken);
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmationEmailToken(String confirmationEmailToken) {
        this.confirmationEmailToken = confirmationEmailToken;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmationEmailToken() {
        return confirmationEmailToken;
    }
}
