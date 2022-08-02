package com.gabriel.microservices.userservice.domain.valueObjects;

import com.gabriel.microservices.userservice.ApplicationTestConfig;
import com.gabriel.microservices.userservice.domain.InvalidFieldException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("EmailTest")
public class EmailTest extends ApplicationTestConfig {

    @Test
    @DisplayName("Não deve permitir email inválido")
    void naoDevePermitirEmailInvalido() {
        Throwable throwable = assertThrows(InvalidFieldException.class, () -> new Email("emailinvalico.com"));
        assertEquals("Email inválido.", throwable.getMessage());
    }
}
