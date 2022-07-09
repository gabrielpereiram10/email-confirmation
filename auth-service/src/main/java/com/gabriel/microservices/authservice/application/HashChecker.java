package com.gabriel.microservices.authservice.application;

public interface HashChecker {

    boolean check(String hashedValue, String value);
}
