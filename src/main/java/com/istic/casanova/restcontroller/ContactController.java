package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Client;
import com.istic.casanova.repository.ClientRepository;
import com.istic.casanova.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/contact")
    public ResponseEntity<Object> contact(@RequestParam Long client,
                                          @RequestParam String message) {
        Optional<Client> clientOptional = clientRepository.findById(client);
        if (clientOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Erreur id client");
        } else {
            Client client1 = clientOptional.get();
            String message1 = "Prénom : " + client1.getPrenom() + "\nNom : " + client1.getNom() + " \nEmail : "
            + client1.getEmail() + "\n" + message;
            emailSenderService.sendEmailContact(message1);
            return ResponseEntity.status(HttpStatus.OK).body("Message send");
        }

    }
}
