package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Client;
import com.istic.casanova.model.ConfirmationToken;
import com.istic.casanova.model.User;
import com.istic.casanova.repository.ClientRepository;
import com.istic.casanova.repository.ConfirmationTokenRepository;
import com.istic.casanova.repository.UserRepository;
import com.istic.casanova.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/validate_user")
    public String sendValidationEmail(@RequestParam String email) {
        Optional<Client> optionalClient = clientRepository.findByEmail(email);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            ConfirmationToken confirmationToken = new ConfirmationToken(client);

            confirmationTokenRepository.save(confirmationToken);
// A compléter
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo();
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:8080/auth/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);
            return "Email envoyé";
        } else {
            return "Aucun client ne correspond à l'email "+email;
        }
    }

    @GetMapping(value="/confirm-account")
    public String confirmUserAccount(@RequestParam("token")String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if(token != null) {
            Optional<Client> optionalClient = clientRepository.findByEmail(token.getClient().getEmail());
            if (optionalClient.isPresent()) {
                Client client = optionalClient.get();
                client.setIsEnabled(true);
                clientRepository.save(client);
                return "Compte verifié";
            } else {
                return "Client introuvable";
            }
        } else {
            return "Erreur. Lien invalide";
        }
    }
}
