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

    @Test
    void senhaDeverConterPeloMenosUmaLetraMaiuscula() {
        InvalidFieldException exception = assertThrows(InvalidFieldException.class, () -> new Password("aaaaaa"));
        assertAll(
                () -> assertEquals("senha", exception.getFiled()),
                () -> assertEquals("Senha deve conter pelo menos uma letra maiúscula.", exception.getMessage())
        );
    }

    @Test
    void senhaDeverConterPeloMenosUmaLetraMinuscula() {
        InvalidFieldException exception = assertThrows(InvalidFieldException.class, () -> new Password("AAAAAA"));
        assertAll(
                () -> assertEquals("senha", exception.getFiled()),
                () -> assertEquals("Senha deve conter pelo menos uma letra minúscula.", exception.getMessage())
        );
    }
}
