package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.application.contracts.Encoder;
import com.gabriel.microservices.userservice.application.contracts.MailSender;
import com.gabriel.microservices.userservice.domain.IUserRepository;
import com.gabriel.microservices.userservice.domain.User;
import com.gabriel.microservices.userservice.domain.valueObjects.Password;

public class RegisterUserUseCase {

    private final IUserRepository repository;
    private final Encoder encoder;
    private final MailSender mailSender;

    public RegisterUserUseCase(IUserRepository repository, Encoder encoder, MailSender mailSender) {
        this.repository = repository;
        this.encoder = encoder;
        this.mailSender = mailSender;
    }

    public void execute(RegisterUserDTO dto) {
        User user = dto.buildEntity();
        boolean userAlreadyExists = repository.existsByEmail(user.getEmail());
        if (userAlreadyExists) {
            throw new UserAlreadyExistsException("email", "Email já cadastrado.");
        }

        String hashedPassword = encoder.encode(user.getPassword().getValue());
        user.confirmPassword(new Password(hashedPassword), dto.getPassword(), dto.getConfirmationPassword());
        repository.save(user);
        mailSender.send(new MailSenderDTO(user));
    }
}
