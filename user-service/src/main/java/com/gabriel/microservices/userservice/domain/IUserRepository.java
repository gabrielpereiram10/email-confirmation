package com.gabriel.microservices.userservice.domain;

import com.gabriel.microservices.userservice.domain.valueObjects.Email;

import java.util.Optional;

public interface IUserRepository {

    Optional<User> find(Email email);
    Optional<User> find(String username);
}
