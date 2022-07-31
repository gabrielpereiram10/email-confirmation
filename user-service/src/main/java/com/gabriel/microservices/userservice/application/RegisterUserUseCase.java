package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.domain.IUserRepository;
import com.gabriel.microservices.userservice.domain.User;

import java.util.Optional;

public class RegisterUserUseCase {

    private final IUserRepository repository;
    public RegisterUserUseCase(IUserRepository repository) {
        this.repository = repository;
    }

    public void execute(UserDTO dto) {
        User user = dto.buildUser();
        Optional<User> userWithEmailAlreadyRegistered = repository.find(user.getEmail());
        if (userWithEmailAlreadyRegistered.isPresent()) {
            throw new UserAlreadyExistsException("Email já cadastrado.");
        }

        Optional<User> userWithUsernameAlreadyRegistered = repository.find(user.getUsername());
        if (userWithUsernameAlreadyRegistered.isPresent()) {
            throw new UserAlreadyExistsException("Username já cadastrado.");
        }
    }
}
