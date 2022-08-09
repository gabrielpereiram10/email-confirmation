package com.gabriel.microservices.userservice.infra.repositories;

import com.gabriel.microservices.userservice.domain.IUserRepository;
import com.gabriel.microservices.userservice.domain.User;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;
import com.gabriel.microservices.userservice.presentation.UserModel;

public class UserRepository implements IUserRepository {

    private final UserJpaRepository repository;

    public UserRepository(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByEmail(Email email) {
        System.out.println(repository);
        return repository.existsUserModelByEmail(email.getValue());
    }

    @Override
    public void save(User user) {
        UserModel userModel = new UserModel(
                user.getName(),
                user.getEmail().getValue(),
                user.getHashedPassword(),
                user.getEmailConfirmationToken().toString()
        );

        repository.save(userModel);
    }
}
