package com.istic.casanova.service;

import com.istic.casanova.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ScheduledEmails {

    @Autowired
    private EmailSenderService emailSenderService;
    private static final Logger log = LoggerFactory.getLogger(ScheduledEmails.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron=". . .")
    public void sendEmailForRegister(Client client) {
        emailSenderService.sendEmailModif(client);
    }
}
