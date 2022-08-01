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
        repository.find(user)
                .ifPresent(userAlreadyExists -> {
                    if (userAlreadyExists.getEmail().equals(user.getEmail())) {
                        throw new UserAlreadyExistsException("email", "Email já cadastrado.");
                    }
                    throw new UserAlreadyExistsException("username", "Username já cadastrado.");
                });
    }
}
