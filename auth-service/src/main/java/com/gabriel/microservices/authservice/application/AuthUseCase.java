package com.gabriel.microservices.authservice.application;

public class AuthUseCase {
    
    private final IUserRepository repository;
    public AuthUseCase(IUserRepository repository) {
        this.repository = repository;
    }


    public void execute(UserDTO dto) {
        UserDTO user = repository.findByEmail(dto.getEmail());
        if (user == null) {
            throw new NotFoundException("Email inválido.");
        }
    }
}
