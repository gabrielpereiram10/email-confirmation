package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.domain.IUserRepository;
import com.gabriel.microservices.userservice.domain.User;

public class RegisterUserUseCase {

    private final IUserRepository repository;

    public RegisterUserUseCase(IUserRepository repository) {
        this.repository = repository;
    }

    public void execute(UserDTO dto) {
        User user = dto.buildEntity();
        boolean userAlreadyExists = repository.existsByEmail(user.getEmail());
        if (userAlreadyExists) {
            throw new UserAlreadyExistsException("email", "Email já cadastrado.");
        }
    }
}
