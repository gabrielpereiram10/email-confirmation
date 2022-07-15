package com.gabriel.microservices.authservice.infra.adapters;

import com.gabriel.microservices.authservice.application.contracts.HashChecker;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashAdapter implements HashChecker {

    private MessageDigest algorithm;

    public HashAdapter() {
        try {
            this.algorithm = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public HashAdapter(MessageDigest algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public boolean check(String hashedValue, String value) {
            String hexValue = generate(value);
            return hashedValue.equals(hexValue);
    }

    public String generate(String value) {
        byte[] messageDigestValue = algorithm.digest(value.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexStringValue = new StringBuilder();
        for (byte b : messageDigestValue) {
            hexStringValue.append(String.format("%02X", 0xFF & b));
        }

        return hexStringValue.toString();
    }
}
