package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.ApplicationTestConfig;
import com.gabriel.microservices.userservice.application.contracts.Encoder;
import com.gabriel.microservices.userservice.application.contracts.MailSender;
import com.gabriel.microservices.userservice.domain.IUserRepository;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RegisterUserUseCaseTest")
public class RegisterUserUseCaseTest extends ApplicationTestConfig {

    @MockBean
    private IUserRepository repository;

    @MockBean
    private Encoder encoder;

    @MockBean
    private MailSender mailSender;

    private RegisterUserUseCase sut;

    @BeforeEach
    void setUp() {
        sut = new RegisterUserUseCase(repository, encoder, mailSender);
    }

    @Test
    @DisplayName("Não deve permitir usuário com email já cadastrado")
    void naoDevePermitirUsuarioComEmailJaCadastrado() {
        String password = "aaAA22";
        Email email = new Email("email_cadastrado@gmail.com");
        RegisterUserDTO userWithEmailAlreadyRegistered = new RegisterUserDTO(
                "username",
                "email_cadastrado@gmail.com",
                password,
                password
        );
        Mockito.when(repository.existsByEmail(email)).thenReturn(true);
        UserAlreadyExistsException alreadyRegisteredEmailException = assertThrows(
                UserAlreadyExistsException.class,
                () -> sut.execute(userWithEmailAlreadyRegistered)
        );
        assertAll(
                () -> assertEquals(
                        "Email já cadastrado.",
                        alreadyRegisteredEmailException.getMessage(),
                        "vericação da mensagem de erro"),
                () -> assertEquals(
                        "email",
                        alreadyRegisteredEmailException.getProperty(),
                        "verificação da propriedade"
                )
        );
    }
}
