package com.gabriel.microservices.authservice.infra.http;

import com.gabriel.microservices.authservice.application.AuthUseCase;
import com.gabriel.microservices.authservice.application.UserDTO;
import com.gabriel.microservices.authservice.application.exceptions.InvalidPasswordException;
import com.gabriel.microservices.authservice.application.exceptions.NotFoundException;
import com.gabriel.microservices.authservice.application.exceptions.UnconfirmedEmailException;
import com.gabriel.microservices.authservice.infra.contracts.Encoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthUseCase useCase;

    private final Encoder encoder;

    public AuthController(AuthUseCase useCase, Encoder encoder) {
        this.useCase = useCase;
        this.encoder = encoder;
    }

    @PostMapping
    public TokenDTO handler(@RequestBody UserDTO userDTO) {
        try {
            useCase.execute(userDTO);
            String token = encoder.encode(userDTO.getEmail());
            return new TokenDTO(token);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (InvalidPasswordException | UnconfirmedEmailException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage(), e);
        }
    }
}
