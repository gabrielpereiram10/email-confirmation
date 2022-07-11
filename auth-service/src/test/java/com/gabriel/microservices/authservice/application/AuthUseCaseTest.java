package com.gabriel.microservices.authservice.application;

import com.gabriel.microservices.authservice.application.contracts.HashChecker;
import com.gabriel.microservices.authservice.application.contracts.IUserRepository;
import com.gabriel.microservices.authservice.application.exceptions.InvalidPasswordException;
import com.gabriel.microservices.authservice.application.exceptions.NotFoundException;
import com.gabriel.microservices.authservice.application.exceptions.UnconfirmedEmailException;
import com.gabriel.microservices.authservice.infra.HashAdapter;
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
        HashAdapter hashAdapter = new HashAdapter();
        String hashedPassword = hashAdapter.generate("654321");
        List<UserDTO> users = new ArrayList<>(Collections.singletonList(new UserDTO("email@gmail.com", hashedPassword)));
        IUserRepository repository = new InMemoryUserRepository(users);
        AuthUseCase usecase = new AuthUseCase(repository, hashAdapter);
        UserDTO user = new UserDTO("email@gmail.com", "123456");
        assertThrows(InvalidPasswordException.class, () -> usecase.execute(user));
    }

    @Test
    void naoDeveriaPermitirUsuariaComEmailNaoConfirmado() {
        HashAdapter hashAdapter = new HashAdapter();
        String hashedPassword = hashAdapter.generate("654321");
        List<UserDTO> users = new ArrayList<>(Collections.singletonList(new UserDTO("email@gmail.com", hashedPassword, UserState.INACTIVE)));
        IUserRepository repository = new InMemoryUserRepository(users);
        AuthUseCase usecase = new AuthUseCase(repository, hashAdapter);
        UserDTO user = new UserDTO("email@gmail.com", "654321");
        assertThrows(UnconfirmedEmailException.class, () -> usecase.execute(user));
    }
}
