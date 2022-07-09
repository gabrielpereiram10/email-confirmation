package com.gabriel.microservices.authservice.application;

public interface IUserRepository {
    UserDTO findByEmail(String email);
}
