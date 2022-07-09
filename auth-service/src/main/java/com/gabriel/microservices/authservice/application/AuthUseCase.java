package com.gabriel.microservices.authservice.application;

public class AuthUseCase {
    
    private final IUserRepository repository;
    public AuthUseCase(IUserRepository repository) {
        this.repository = repository;
    }


    public void execute(UserDTO dto) {
        throw new NotFound("Email inválido.");
    }
}
