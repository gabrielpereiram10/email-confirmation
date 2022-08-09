package com.gabriel.microservices.userservice.presentation;

import com.gabriel.microservices.userservice.application.RegisterUserUseCase;
import com.gabriel.microservices.userservice.application.UserAlreadyExistsException;
import com.gabriel.microservices.userservice.application.RegisterUserDTO;
import com.gabriel.microservices.userservice.domain.InvalidFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class RegisterUserController {

    private final RegisterUserUseCase useCase;

    public RegisterUserController(RegisterUserUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void handle(@RequestBody RegisterUserDTO userDTO) {
        try {
            useCase.execute(userDTO);
        } catch (InvalidFieldException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (UserAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
