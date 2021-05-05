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
    public ResponseEntity<Object> contact(@RequestBody Client client, @RequestParam String objet, @RequestParam String message) {
        Optional<Client> clientOptional = clientRepository.findById(client.getId());
        if (clientOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            String message1 = "Prénom : " + client.getPrenom() + "\nNom : " + client.getNom() + " \nEmail : "
                    + client.getEmail() + "\n" + message;
            emailSenderService.sendEmailContact(objet, message1);
            return ResponseEntity.noContent().build();
        }

    }
}
