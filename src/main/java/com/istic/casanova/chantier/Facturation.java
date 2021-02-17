package com.istic.casanova.chantier;

import com.istic.casanova.model.Client;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Facturation {

    @Column(name = "nom_client")

    @ManyToOne
    private Client client;

@OneToOne
    private BonDeCommande bonDeCommande;

    public String getCName() {
        return client.getNom();
    }

    public String getCAdresse() {
        return client.getAdresse();
    }

    public String getCPostalCode() {
        return client.getCode_postal();
    }

    public String getCVille() {
        return client.getVille();
    }
    public String getCTel() {
        return client.getTel_fixe();
    }
    public String getCPortable() {
        return client.getTelPortable();
    }
    public String getCEmail() {
        return client.getEmail();
    }








}