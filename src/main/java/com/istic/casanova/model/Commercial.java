package com.istic.casanova.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Entité Client : Hérite de User
 */

@Entity
public class Commercial extends User {

    private String agence;

    @OneToMany(mappedBy = "commercial")
    private List<Client> clientList =new ArrayList<>();

    public Commercial (){super();}

    public Commercial(String password){
        this.setPassword(password);
    }

    public String getAgence() { return agence;}

    public void setAgence(String agence) {this.agence = agence;}

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
