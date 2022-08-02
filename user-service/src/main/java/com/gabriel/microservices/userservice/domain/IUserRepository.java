package com.gabriel.microservices.userservice.domain;

import com.gabriel.microservices.userservice.domain.valueObjects.Email;

public interface IUserRepository {

    boolean existsByEmail(Email email);
}
