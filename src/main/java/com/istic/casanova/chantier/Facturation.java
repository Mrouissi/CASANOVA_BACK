package com.istic.casanova.chantier;

import com.istic.casanova.model.Client;

import javax.persistence.*;

@Entity
public class Facturation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facturation_id")
    private Long id;

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