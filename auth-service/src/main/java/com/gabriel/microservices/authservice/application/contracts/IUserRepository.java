package com.gabriel.microservices.authservice.application.contracts;

import com.gabriel.microservices.authservice.application.UserDTO;

public interface IUserRepository {
    UserDTO findByEmail(String email);
}
