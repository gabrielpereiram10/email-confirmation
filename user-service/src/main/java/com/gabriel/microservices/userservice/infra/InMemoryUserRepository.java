package com.gabriel.microservices.userservice.infra;

import com.gabriel.microservices.userservice.domain.IUserRepository;
import com.gabriel.microservices.userservice.domain.User;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;

import java.util.ArrayList;
import java.util.Optional;

public class InMemoryUserRepository implements IUserRepository {

    private final ArrayList<User> users;

    public InMemoryUserRepository(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public Optional<User> find(Email email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public Optional<User> find(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }
}