package com.gabriel.microservices.authservice.application.exceptions;

public class UnconfirmedEmailException extends RuntimeException {

    public UnconfirmedEmailException() {
        super("Confirme seu email atraves do link enviado ao endereço cadastrado.");
    }
}
