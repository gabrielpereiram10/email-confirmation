package com.gabriel.microservices.userservice.application;

import com.gabriel.microservices.userservice.domain.User;

import java.util.UUID;

public class MailSenderDTO {

    private String receiverName, receiverEmail;
    private UUID confirmationKey;

    protected MailSenderDTO(User user) {
        this.receiverName = user.getName();
        this.receiverEmail = user.getEmail().getValue();
        this.confirmationKey = user.getEmailConfirmationToken();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public UUID getConfirmationKey() {
        return confirmationKey;
    }

    public void setConfirmationKey(UUID confirmationKey) {
        this.confirmationKey = confirmationKey;
    }
}
