package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Entité Chantier : Contient les informations d'un chantier.
 */
@Entity
@Table(name = "chantier")
public class Chantier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chantier_id")
    private Long id;

    /**
     * Dossier lié au Chantier
     */
    @OneToOne
    @JsonBackReference(value = "dossier_chantier")
    private Dossier dossier;

    /**
     * Travaux liés au Chantier
     */
    @OneToMany
    @JsonManagedReference(value = "chantier_travaux")
    private Travaux travaux;

    /**
     * État d'avancement
     */
    private String etat_chantier;


    /* Infos Chantier*/

    @Column(name = "code_postal")
    private String code_postal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "observation")
    private String observation;

    @Column(name = "conseiller")
    private String conseiller;

    @Column(name = "inspecteur")
    private String inspecteur;

    @Column(name = "anticipable")
    private String anticipable;

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

    public String getEtat_chantier() { return etat_chantier; }
    public void setEtat_chantier(String etat_chantier) { this.etat_chantier = etat_chantier; }

    public String getCode_postal() {
        return code_postal;
    }
    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }

    public String getConseiller() { return conseiller; }
    public void setConseiller(String conseiller) { this.conseiller = conseiller; }

    public String getInspecteur() { return inspecteur; }
    public void setInspecteur(String inspecteur) { this.inspecteur = inspecteur; }

    public String getAnticipable() { return anticipable; }
    public void setAnticipable(String anticipable) { this.anticipable = anticipable; }

    public String getVisite_technique() { return visite_technique; }
    public void setVisite_technique(String visite_technique) { this.visite_technique = visite_technique; }
}
