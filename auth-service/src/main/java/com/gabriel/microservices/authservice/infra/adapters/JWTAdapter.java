package com.gabriel.microservices.authservice.infra.adapters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gabriel.microservices.authservice.infra.contracts.Encoder;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JWTAdapter implements Encoder {

    @Value("${jwt.secretKey}")
    private String JWT_SECRET_KEY;

    @Value("${jwt.expiresAt}")
    private String JWT_EXPIRES_AT;

    @Override
    public String encode(String value) {
        Algorithm algorithm = Algorithm.HMAC512(JWT_SECRET_KEY);
        Date expiresAt = new Date(System.currentTimeMillis() + Integer.parseInt(JWT_EXPIRES_AT));
        return JWT.create()
                .withSubject(value)
                .withExpiresAt(expiresAt)
                .sign(algorithm);
    }
}
