package com.istic.casanova.service;

import com.istic.casanova.model.Client;
import com.istic.casanova.model.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailSenderService")
public class EmailSenderService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Envoi email
     * @param client
     */
    @Async
    public void sendEmailModif(Client client) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("");
        mailMessage.setSubject("Modification Info client ");
        mailMessage.setFrom("");
        mailMessage.setText(client.getNom() + "a changé ses infos");
        javaMailSender.send(mailMessage);
    }

    /**
     * Envoi un email de confirmation
     * @param client
     * @param confirmationToken
     */
    @Async
    public void sendEmailConfirmation(Client client, ConfirmationToken confirmationToken) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(client.getEmail());
        mailMessage.setSubject("Vérifier votre compte Label France Toiture !");
        mailMessage.setFrom("");
        mailMessage.setText("Cliquez ici pour confirmer votre compte : "
                +"http://localhost:8080/auth/confirm-account?token="+confirmationToken.getConfirmationToken());

        javaMailSender.send(mailMessage);
    }

    /**
     * Envoi un email de contact
     * @param message
     *
     */
    @Async
    public void sendEmailContact(String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("");
        mailMessage.setSubject("Contact Interface");
        mailMessage.setFrom("");
        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
    }



}
