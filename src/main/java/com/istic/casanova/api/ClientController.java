package com.istic.casanova.api;

import com.istic.casanova.model.Client;
import com.istic.casanova.service.impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/client")
@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void addClient(@RequestBody Client client) {
        this.clientService.addClient(client);
    }

    @GetMapping
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping(path = "{id}")
    public Client getClientById(@PathVariable("id") UUID id) {
        return clientService.getClientById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteClientById(@PathVariable("id") UUID id) {
        clientService.deleteClient(id);
    }

    @PutMapping(path = "{id}")
    public void updateClientById(@PathVariable("id") UUID id, @RequestBody Client clientToUpdate) {
        clientService.updateClient(id, clientToUpdate);
    }
}
