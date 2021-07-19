package com.istic.casanova.model;

import javax.persistence.Entity;

/**
 * Entité Client : Hérite de User
 */
@Entity
public class Commercial extends User {

    private String agence;

    public Commercial (){super();}

    public Commercial(String password){
        this.setPassword(password);
    }

    public String getAgence() { return agence;}

    public void setAgence(String agence) {this.agence = agence;}


}
