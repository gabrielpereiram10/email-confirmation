package com.gabriel.microservices.authservice.application;

import com.gabriel.microservices.authservice.application.contracts.HashChecker;
import com.gabriel.microservices.authservice.application.contracts.IUserRepository;
import com.gabriel.microservices.authservice.application.exceptions.InvalidPasswordException;
import com.gabriel.microservices.authservice.application.exceptions.NotFoundException;
import com.gabriel.microservices.authservice.application.exceptions.UnconfirmedEmailException;

public class AuthUseCase {
    
    private final IUserRepository repository;
    private final HashChecker passwordChecker;
    public AuthUseCase(IUserRepository repository, HashChecker passwordChecker) {
        this.repository = repository;
        this.passwordChecker = passwordChecker;
    }


    public void execute(UserDTO dto) {
        UserDTO user = repository.findByEmail(dto.getEmail());
        if (user == null) throw new NotFoundException("Email inválido.");

        boolean invalidPassword = !passwordChecker.check(user.getPassword(), dto.getPassword());
        if (invalidPassword) throw new InvalidPasswordException();

        throw new UnconfirmedEmailException();
    }
}
