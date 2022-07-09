package com.gabriel.microservices.authservice.application;

import com.gabriel.microservices.authservice.infra.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthUseCaseTest {

    @Test
    void naoDeveriaPermitirEmailNaoCadastrado() {
        IUserRepository repository = new InMemoryUserRepository();
        HashChecker passwordChecker = new HashAdapter();
        AuthUseCase usecase = new AuthUseCase(repository, passwordChecker);
        UserDTO user = new UserDTO("email_nao_cadastrado@gmail.com", "123456");
        assertThrows(NotFoundException.class, () -> usecase.execute(user));
    }

    @Test
    void naoDeveriaPermitirSenhaDiferenteDaSenhaCadastrada() {
        List<UserDTO> users = new ArrayList<>(Collections.singletonList(new UserDTO("email@gmail.com", "654321")));
        IUserRepository repository = new InMemoryUserRepository(users);
        HashChecker passwordChecker = new HashAdapter();
        AuthUseCase usecase = new AuthUseCase(repository, passwordChecker);
        UserDTO user = new UserDTO("email@gmail.com", "123456");
        assertThrows(InvalidPasswordException.class, () -> usecase.execute(user));
    }
}
