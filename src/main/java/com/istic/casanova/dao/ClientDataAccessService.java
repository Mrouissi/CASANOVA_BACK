package com.istic.casanova.dao;

import com.istic.casanova.dao.ClientDao;
import com.istic.casanova.model.Client;
import org.hibernate.hql.internal.ast.ParseErrorHandler;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class ClientDataAccessService implements ClientDao {

    private static List<Client> Clients = new ArrayList<>();

    @Override
    public int insertClient(UUID id, Client client) {
//        Clients.add(new Client(id, client.getNom(), client.getPrenom(), client.getCivilite(), client.getVille(),
//                client.getCodePostal(), client.getAdresse(), client.getMail(), client.getTelFixe(),
//                client.getTelPortable(), client.getProfil(), client.getProfession()));
        Clients.add(new Client(client));
        return 1;
    }

    @Override
    public List<Client> selectAllClient() {
        return Clients;
    }

    @Override
    public Optional<Client> selectClientById(UUID id) {
        return Clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteClientById(UUID id) {
        Optional<Client> clientMaybe = selectClientById(id);
        if (clientMaybe.isEmpty()) {
            return 0;
        }
        Clients.remove(clientMaybe.get());
        return 1;
    }

    @Override
    public int updateClientById(UUID id, Client update) {
        return selectClientById(id)
                .map(client -> {
                    int indexOfClientToUpdate = Clients.indexOf(client);
                    if (indexOfClientToUpdate >= 0) {
//                        Clients.set(indexOfClientToUpdate, new Client(id,
//                                update.getNom(), update.getPrenom(), update.getCivilite(), update.getVille(),
//                                update.getCodePostal(), update.getAdresse(), update.getMail(), update.getTelFixe(),
//                                update.getTelPortable(), update.getProfil(), update.getProfession()));
                        Clients.set(indexOfClientToUpdate, new Client(client));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
