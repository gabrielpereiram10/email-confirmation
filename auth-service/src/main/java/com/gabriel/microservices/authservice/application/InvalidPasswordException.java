package com.gabriel.microservices.authservice.application;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("Senha inválida.");
    }
}
