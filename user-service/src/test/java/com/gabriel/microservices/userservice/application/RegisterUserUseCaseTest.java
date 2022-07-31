package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.domain.IUserRepository;
import com.gabriel.microservices.userservice.domain.User;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;
import com.gabriel.microservices.userservice.domain.valueObjects.Password;
import com.gabriel.microservices.userservice.infra.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterUserUseCaseTest {

    @Test
    void naoDevePermitirUsuarioJaCadastrado() {
        String password = "aaAA22";
        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User(
                        "algo",
                        new Email("email_cadastrado@gmail.com"),
                        new Password(password)
                ),
                new User(
                        "username_already_registered",
                        new Email("algo@gmail.com"),
                        new Password(password)
                )
        ));

        UserDTO userWithEmailAlreadyRegistered = new UserDTO(
                "username",
                "email_cadastrado@gmail.com",
                password
        );
        UserDTO userWithUsernameAlreadyRegistered = new UserDTO(
                "username_already_registered",
                "email_nao_cadastrado@gmail.com",
                password
        );

        IUserRepository userRepository = new InMemoryUserRepository(users);
        RegisterUserUseCase useCase = new RegisterUserUseCase(userRepository);

        Throwable alreadyRegisteredEmailException = assertThrows(
                UserAlreadyExistsException.class,
                () -> useCase.execute(userWithEmailAlreadyRegistered)
        );
        Throwable alreadyRegisteredUsernameException = assertThrows(
                UserAlreadyExistsException.class,
                () -> useCase.execute(userWithUsernameAlreadyRegistered)
        );

        assertAll(
                () -> assertEquals(
                        "Email já cadastrado.",
                        alreadyRegisteredEmailException.getMessage()
                ),
                () -> assertEquals(
                        "Username já cadastrado.",
                        alreadyRegisteredUsernameException.getMessage()
                )
        );
    }
}
