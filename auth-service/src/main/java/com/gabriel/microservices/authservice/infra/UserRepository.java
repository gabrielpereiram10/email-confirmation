package com.gabriel.microservices.authservice.infra;

import com.gabriel.microservices.authservice.application.IUserRepository;
import com.gabriel.microservices.authservice.application.UserDTO;

public class UserRepository implements IUserRepository {
    @Override
    public UserDTO findByEmail(String email) {
        return null;
    }
}
