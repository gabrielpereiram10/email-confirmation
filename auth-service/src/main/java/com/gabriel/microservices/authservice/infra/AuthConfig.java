package com.gabriel.microservices.authservice.infra;

import com.gabriel.microservices.authservice.application.AuthUseCase;
import com.gabriel.microservices.authservice.application.UserDTO;
import com.gabriel.microservices.authservice.application.UserState;
import com.gabriel.microservices.authservice.application.contracts.IUserRepository;
import com.gabriel.microservices.authservice.infra.adapters.HashAdapter;
import com.gabriel.microservices.authservice.infra.adapters.InMemoryUserRepository;
import com.gabriel.microservices.authservice.infra.adapters.JWTAdapter;
import com.gabriel.microservices.authservice.infra.contracts.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class AuthConfig {

    @Bean
    public AuthUseCase createUseCase() {
        HashAdapter hashAdapter = new HashAdapter();
        String hashedPassword = hashAdapter.generate("654321");
        List<UserDTO> users = new ArrayList<>(Collections.singletonList(new UserDTO("email@gmail.com", hashedPassword, UserState.ACTIVE)));
        IUserRepository repository = new InMemoryUserRepository(users);
        return new AuthUseCase(repository, hashAdapter);
    }

    @Bean
    public Encoder getEncoder() {
        return new JWTAdapter();
    }
}
