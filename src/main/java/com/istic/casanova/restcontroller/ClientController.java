package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Client;
import com.istic.casanova.model.ConfirmationToken;
import com.istic.casanova.model.Dossier;
import com.istic.casanova.model.User;
import com.istic.casanova.repository.ClientRepository;
import com.istic.casanova.repository.DossierRepository;
import com.istic.casanova.service.EmailSenderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client getClientsById(@PathVariable Long id) throws NotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty()) {
            throw new NotFoundException("Client not found, id : "+id);
        }
        return client.get();
    }

    @GetMapping("/clients/mail/{email}")
    public Client getClientByEmail(@PathVariable String email) throws NotFoundException {
        Optional<Client> client = clientRepository.findByEmail(email);
        if(client.isEmpty()) {
            throw new NotFoundException("Client not found, email : "+email);
        }
        return client.get();
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable long id) {
        clientRepository.deleteById(id);
    }

    @PostMapping("/clients")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        Optional<Client> testClient = clientRepository.findByEmail(client.getEmail());
        if (testClient.isEmpty()) {
            User savedUser = clientRepository.save(client);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("User created");
        } else {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Email already use");
        }
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Object> updateClient(@RequestBody Client client, @PathVariable long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isEmpty())
            return ResponseEntity.notFound().build();
        client.setId(id);
        clientRepository.save(client);
        this.sendEmail(client);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clients/{id}/dossiers")
    public List<Dossier> getDossiersByIdClient(@PathVariable Long id) throws NotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        List<Dossier> dossiers;
        if(client.isEmpty()) {
            throw new NotFoundException("Client not found, id : "+id);
        } else {
            dossiers = dossierRepository.findDossierByIdClient(id);
        }
        return dossiers;
    }

    public String sendEmail(Client client) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("sperdk22@gmail.com");
        mailMessage.setSubject("Modification Info client ");
        mailMessage.setFrom("t.lvq22@gmail.com");
        mailMessage.setText(client.getNom() + "a changé ses infos");

        emailSenderService.sendEmail(mailMessage);
        return "Email envoyé";
    }
}