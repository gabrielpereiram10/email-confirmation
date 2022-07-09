package com.gabriel.microservices.authservice.application;

public class HashAdapter implements HashChecker {

    @Override
    public boolean check(String hashedValue, String value) {
        return false;
    }
}
