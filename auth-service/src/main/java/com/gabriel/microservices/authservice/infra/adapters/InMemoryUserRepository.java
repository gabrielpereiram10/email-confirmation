package com.gabriel.microservices.authservice.infra.adapters;

import com.gabriel.microservices.authservice.application.contracts.IUserRepository;
import com.gabriel.microservices.authservice.application.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryUserRepository implements IUserRepository {

    private final List<UserDTO> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    public InMemoryUserRepository(List<UserDTO> users) {
        this.users = users;
    }

    @Override
    public UserDTO findByEmail(String email) {
        try {
            return users.stream()
                    .filter(user -> user.getEmail().equals(email))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
