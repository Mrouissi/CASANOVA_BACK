package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Client;
import com.istic.casanova.repository.ClientRepository;
import com.istic.casanova.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class ContactController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @PutMapping("/contact")
    public ResponseEntity<Object> contact(@RequestParam Long client,
                                          @RequestParam String message) {
        Optional<Client> clientOptional = clientRepository.findById(client);
        if (clientOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Client client1 = clientOptional.get();
            String message1 = "Prénom : " + client1.getPrenom() + "\nNom : " + client1.getNom() + " \nEmail : "
            + client1.getEmail() + "\n" + message;
            emailSenderService.sendEmailContact(message1);
            return ResponseEntity.noContent().build();
        }

    }
}
