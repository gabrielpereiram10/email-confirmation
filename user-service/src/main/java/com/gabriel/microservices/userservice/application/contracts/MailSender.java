package com.gabriel.microservices.userservice.application.contracts;

import com.gabriel.microservices.userservice.application.MailSenderDTO;

public interface MailSender {

    void send(MailSenderDTO dto);
}
