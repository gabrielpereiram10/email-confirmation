package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.domain.IUserRepository;
import com.gabriel.microservices.userservice.domain.User;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;
import com.gabriel.microservices.userservice.domain.valueObjects.Password;
import com.gabriel.microservices.userservice.infra.InMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RegisterUserUseCaseTest")
public class RegisterUserUseCaseTest {

    private RegisterUserUseCase useCase;
    private String password;

    @BeforeEach
    void setUp() {
        password = "aaAA22";
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
        IUserRepository repository = new InMemoryUserRepository(users);
        useCase = new RegisterUserUseCase(repository);
    }

    @Test
    @DisplayName("Não deve permitir usuário com email já cadastrado")
    void naoDevePermitirUsuarioComEmailJaCadastrado() {
        UserDTO userWithEmailAlreadyRegistered = new UserDTO(
                "username",
                "email_cadastrado@gmail.com",
                password
        );

        Throwable alreadyRegisteredEmailException = assertThrows(
                UserAlreadyExistsException.class,
                () -> useCase.execute(userWithEmailAlreadyRegistered)
        );

        causeTest(alreadyRegisteredEmailException, "Email já cadastrado.", "email");

    }

    @Test
    @DisplayName("Não deve permitir usuário com username já cadastrado")
    void naoDevePermitirUsuarioComUsernameJaCadastrado() {
        UserDTO userWithUsernameAlreadyRegistered = new UserDTO(
                "username_already_registered",
                "email_nao_cadastrado@gmail.com",
                password
        );

        Throwable alreadyRegisteredUsernameException = assertThrows(
                UserAlreadyExistsException.class,
                () -> useCase.execute(userWithUsernameAlreadyRegistered)
        );

        causeTest(alreadyRegisteredUsernameException, "Username já cadastrado.", "username");
    }

    private void causeTest(Throwable cause, String message, String property) {
        UserAlreadyExistsException exception = (UserAlreadyExistsException) cause;

        assertAll(
                () -> assertEquals(
                        message,
                        exception.getMessage(),
                        "vericação da mensagem de erro"),
                () -> assertEquals(
                        property,
                        exception.getProperty(),
                        "verificação da propriedade"
                )
        );
    }
}
