package com.istic.casanova.restcontroller;

import com.istic.casanova.extract.UserExcelExporter;
import com.istic.casanova.model.*;
import com.istic.casanova.repository.ClientRepository;
import com.istic.casanova.repository.DossierRepository;
import com.istic.casanova.repository.PeriodeAbsRepository;
import com.istic.casanova.service.ClientServices;
import com.istic.casanova.service.EmailSenderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientServices service;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private PeriodeAbsRepository periodeAbsRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    /**
     *
     * @return liste clients
     */
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     *
     * @param id
     * @return client
     * @throws NotFoundException
     */
    @GetMapping("/clients/{id}")
    public Client getClientsById(@PathVariable Long id) throws NotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty()) {
            throw new NotFoundException("Client not found, id : "+id);
        }
        return client.get();
    }

    /**
     *
     * @param email
     * @return client
     * @throws NotFoundException
     */
    @GetMapping("/clients/mail/{email}")
    public Client getClientByEmail(@PathVariable String email) throws NotFoundException {
        Optional<Client> client = clientRepository.findByEmail(email);
        if(client.isEmpty()) {
            throw new NotFoundException("Client not found, email : "+email);
        }
        return client.get();
    }

    /**
     * Supprime client
     * @param id
     */
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable long id) {
        clientRepository.deleteById(id);
    }

    /**
     * Créer client
     * @param client
     * @return reponse
     */

    //créer un client
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

    /**
     * Modifier client
     * @param client
     * @param id
     * @return reponse
     */
    @PutMapping("/clients/{id}")
    public ResponseEntity<Object> updateClient(@RequestBody Client client, @PathVariable long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            String pass = clientOptional.get().getPassword();
            Boolean is_enable = clientOptional.get().getIsEnabled();
            client.setId(id);
            client.setPassword(pass);
            client.setIsEnabled(is_enable);
            clientRepository.save(client);
            emailSenderService.sendEmailModif(client);
            return ResponseEntity.noContent().build();
        }

    }

    /**
     *
     * @param id
     * @return liste des dossiers d'un client
     * @throws NotFoundException
     */
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

    /**
     *
     * @param id
     * @return la liste des periodes d'absences
     * @throws NotFoundException
     */
    @GetMapping("/clients/{id}/absences")
    public List<PeriodeAbs> getPeriodeAbs(@PathVariable Long id) throws NotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        List<PeriodeAbs> periodeAbs;
        if(client.isEmpty()) {
            throw new NotFoundException("Client not found, id : "+id);
        } else {
            periodeAbs = periodeAbsRepository.findPeriodeAbsByIdClient(id);
        }
        return periodeAbs;
    }

    /**
     * creation d'une periode d'absence
     * @param id
     * @param periodeAbs
     * @return reponse
     * @throws NotFoundException
     */
    @PostMapping("/clients/{id}/absences")
    public ResponseEntity<String> createPeriodeAbs(@PathVariable Long id, @RequestBody PeriodeAbs periodeAbs) throws NotFoundException {
        Optional<Client> testClient = clientRepository.findById(id);
        if(testClient.isEmpty()) {
            throw new NotFoundException("Client not found, id : " + id);
        } else {
           PeriodeAbs savedPeriodeAbs = periodeAbsRepository.save(periodeAbs);
            emailSenderService.sendEmailAbs("Client " + testClient.get().getNom() + " " +testClient.get().getPrenom()+".\n"
                                            + "Période d'absence du " + periodeAbs.getDate_debut() +" au "+ periodeAbs.getDate_fin(), testClient.get().getEmail());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("PeriodeAbs created");
        }
    }

    /**
     * Génére fichier excel
     * @param response
     * @throws IOException
     */
    @GetMapping("/client/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Clients_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<Client> listClients = getAllClients();
        UserExcelExporter excelExporter = new UserExcelExporter(listClients);
        excelExporter.export(response);
    }
}