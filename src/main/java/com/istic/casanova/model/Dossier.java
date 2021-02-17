package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.istic.casanova.enums.EtatDossier;

import javax.persistence.*;

@Entity
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dossier_id")
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Client client;

    @Enumerated(EnumType.STRING)
    private EtatDossier etatDossier;

    @OneToOne
    @JsonBackReference
    private Chantier chantier;

    @Column(name = "montantAcompte")
    private String montantAcompte;

    @Column(name = "montantTotal")
    private String montantTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EtatDossier getEtatDossier() { return etatDossier; }

    public void setEtatDossier(EtatDossier etatDossier) {
        this.etatDossier = etatDossier;
    }

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    public String getMontantAcompte() {
        return montantAcompte;
    }

    public void setMontantAcompte(String montantAcompte) {
        this.montantAcompte = montantAcompte;
    }

    public String getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(String montantTotal) {
        this.montantTotal = montantTotal;
    }
}
