package com.gabriel.microservices.userservice.domain;

import com.gabriel.microservices.userservice.domain.exceptions.InvalidFieldException;
import com.gabriel.microservices.userservice.domain.valueObjects.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @Test
    void senhaDeveConterPeloMenosSeisCaracteres() {
        InvalidFieldException exception = assertThrows(InvalidFieldException.class, () -> new Password("aaaaa"));
        assertAll(
                () -> assertEquals("senha", exception.getFiled()),
                () -> assertEquals("Senha deve conter pelo menos 6 caracteres.", exception.getMessage())
        );
    }
}
