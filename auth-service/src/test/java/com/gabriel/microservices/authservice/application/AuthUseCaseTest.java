package com.gabriel.microservices.authservice.application;

import com.gabriel.microservices.authservice.infra.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthUseCaseTest {

    @Test
    void naoDeveriaPermitirEmailNaoCadastrado() {
        IUserRepository repository = new InMemoryUserRepository();
        AuthUseCase usecase = new AuthUseCase(repository);
        UserDTO user = new UserDTO("email@gmail.com", "123456");
        assertThrows(NotFoundException.class, () -> usecase.execute(user));
    }
}
