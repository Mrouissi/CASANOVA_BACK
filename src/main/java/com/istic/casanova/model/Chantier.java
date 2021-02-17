package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "chantier")
public class Chantier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chantier_id")
    private Long id;

    @OneToOne
    @JsonManagedReference
    private Dossier dossier;

    @Column(name = "code_postal")
    private String code_postal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "date_commande")
    private String date_commande;

    @Column(name = "date_limite")
    private String date_limite;

    @Column(name = "observation")
    private String observation;

    @Column(name = "conseiller")
    private String conseiller;

    @Column(name = "inspecteur")
    private String inspecteur;

    @Column(name = "anticipable")
    private String anticipable;

    @Column(name = "travaux")
    private String travaux;

    @Column(name = "visite_technique")
    private String visite_technique;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @OneToOne
    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }

    public String getDate_limite() {
        return date_limite;
    }

    public void setDate_limite(String date_limite) {
        this.date_limite = date_limite;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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

    public String getAnticipable() {
        return anticipable;
    }

    public void setAnticipable(String anticipable) {
        this.anticipable = anticipable;
    }

    public String getTravaux() {
        return travaux;
    }

    public void setTravaux(String travaux) {
        this.travaux = travaux;
    }

    public String getVisite_technique() {
        return visite_technique;
    }

    public void setVisite_technique(String visite_technique) {
        this.visite_technique = visite_technique;
    }
}
