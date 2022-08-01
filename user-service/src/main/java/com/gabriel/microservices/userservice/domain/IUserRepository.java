package com.gabriel.microservices.userservice.domain;

import com.gabriel.microservices.userservice.domain.valueObjects.Email;

import java.util.Optional;

public interface IUserRepository {

    Optional<User> find(User user);
}
