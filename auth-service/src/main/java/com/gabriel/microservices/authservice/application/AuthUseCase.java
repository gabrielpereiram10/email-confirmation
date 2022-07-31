package com.gabriel.microservices.authservice.application;

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
