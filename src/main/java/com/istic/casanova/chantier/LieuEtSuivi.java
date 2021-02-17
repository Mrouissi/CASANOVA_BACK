package com.istic.casanova.chantier;

import javax.persistence.*;

public class LieuEtSuivi {


    @Column(name = "adresse")
    private String adresse;

    @Column(name = "CP+ville")
    private String cpEtVille;

    @Column(name = "observation")
    private String observation;

    @Column(name = "date_limite")
    private String dateLimite;

    @Column(name = "conseiller")
    private String conseiller;

    @Column(name = "inspecteur")
    private String inspecteur;


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCpEtVille() {
        return cpEtVille;
    }

    public void setCpEtVille(String cpEtVille) {
        this.cpEtVille = cpEtVille;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(String dateLimite) {
        this.dateLimite = dateLimite;
    }

    public String getConseiller() {
        return conseiller;
    }

    public void setConseiller(String conseiller) {
        this.conseiller = conseiller;
    }

    public String getInspecteur() {
        return inspecteur;
    }

    public void setInspecteur(String inspecteur) {
        this.inspecteur = inspecteur;
    }
}