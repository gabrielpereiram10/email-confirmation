package com.gabriel.microservices.userservice.domain;

import com.gabriel.microservices.userservice.domain.exceptions.InvalidFieldException;
import com.gabriel.microservices.userservice.domain.valueObjects.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {

    @Test
    void naoDevePermitirEmailInvalido() {
        Throwable throwable = assertThrows(InvalidFieldException.class, () -> new Email("emailinvalico.com"));
        assertEquals("Email inválido.", throwable.getMessage());
    }
}
