package com.gabriel.microservices.authservice.application.contracts;

public interface HashChecker {

    boolean check(String hashedValue, String value);
}
