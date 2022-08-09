package com.gabriel.microservices.userservice.infra.config;

import com.gabriel.microservices.userservice.application.RegisterUserUseCase;
import com.gabriel.microservices.userservice.application.contracts.Encoder;
import com.gabriel.microservices.userservice.application.contracts.MailSender;
import com.gabriel.microservices.userservice.domain.IUserRepository;
import com.gabriel.microservices.userservice.infra.adapters.ConfirmationMailSender;
import com.gabriel.microservices.userservice.infra.adapters.HashGenerator;
import com.gabriel.microservices.userservice.infra.repositories.UserJpaRepository;
import com.gabriel.microservices.userservice.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Bean
    public RegisterUserUseCase createRegisterUserUseCase() {
        IUserRepository repository = new UserRepository(userJpaRepository);
        Encoder encoder = new HashGenerator();
        MailSender mailSender = new ConfirmationMailSender();
        return new RegisterUserUseCase(repository, encoder, mailSender);
    }
}
