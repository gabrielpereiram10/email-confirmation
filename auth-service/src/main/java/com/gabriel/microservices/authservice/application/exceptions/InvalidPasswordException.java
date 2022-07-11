package com.gabriel.microservices.authservice.application.exceptions;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("Senha inválida.");
    }
}
