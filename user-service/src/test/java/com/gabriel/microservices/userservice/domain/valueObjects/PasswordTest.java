package com.gabriel.microservices.userservice.domain.valueObjects;

import com.gabriel.microservices.userservice.ApplicationTestConfig;
import com.gabriel.microservices.userservice.domain.InvalidFieldException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PasswordTest")
public class PasswordTest extends ApplicationTestConfig {

    @Test
    @DisplayName("Deve conter pelo menos seis caracteres")
    void senhaDeveConterPeloMenosSeisCaracteres() {
        InvalidFieldException exception = assertThrows(InvalidFieldException.class, () -> new Password("aaaaa"));
        assertAll(
                () -> assertEquals("senha", exception.getFiled()),
                () -> assertEquals("Senha deve conter pelo menos 6 caracteres.", exception.getMessage())
        );
    }

    @Test
    @DisplayName("Deve conter pelo menos uma letra maiúscula")
    void senhaDeverConterPeloMenosUmaLetraMaiuscula() {
        InvalidFieldException exception = assertThrows(InvalidFieldException.class, () -> new Password("aaaaaa"));
        assertAll(
                () -> assertEquals("senha", exception.getFiled()),
                () -> assertEquals("Senha deve conter pelo menos uma letra maiúscula.", exception.getMessage())
        );
    }

    @Test
    @DisplayName("Deve conter pelo menos uma letra minúscula")
    void senhaDeverConterPeloMenosUmaLetraMinuscula() {
        InvalidFieldException exception = assertThrows(InvalidFieldException.class, () -> new Password("AAAAAA"));
        assertAll(
                () -> assertEquals("senha", exception.getFiled()),
                () -> assertEquals("Senha deve conter pelo menos uma letra minúscula.", exception.getMessage())
        );
    }
}
