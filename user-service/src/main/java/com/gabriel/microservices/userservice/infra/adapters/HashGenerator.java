package com.gabriel.microservices.userservice.infra.adapters;

import com.gabriel.microservices.userservice.application.contracts.Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator implements Encoder {

    private MessageDigest algorithm;

    public HashGenerator() {
        try {
            this.algorithm = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public HashGenerator(MessageDigest algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String encode(String value) {
        byte[] messageDigestValue = algorithm.digest(value.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexStringValue = new StringBuilder();
        for (byte b : messageDigestValue) {
            hexStringValue.append(String.format("%02X", 0xFF & b));
        }

        return hexStringValue.toString();
    }
}
