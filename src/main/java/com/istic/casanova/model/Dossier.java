package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.istic.casanova.utils.enums.EtatDossier;

import javax.persistence.*;
import java.util.Date;

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
    private EtatDossier etat_dossier;

    @Enumerated(EnumType.STRING)
    private EtatDossier etat_chaniter;

    @OneToOne
    @JsonBackReference
    private Chantier chantier;

    @Column(name = "montant_acompte")
    private String montant_acompte;

    @Column(name = "montant_total")
    private String montant_total;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_commande")
    private Date date_commande;

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

    public EtatDossier getEtat_dossier() { return etat_dossier; }

    public void setEtatDossier(EtatDossier etat_dossier) {
        this.etat_dossier = etat_dossier;
    }

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    public String getMontant_acompte() {
        return montant_acompte;
    }

    public void setMontant_acompte(String montant_acompte) {
        this.montant_acompte = montant_acompte;
    }

    public String getMontant_total() {
        return montant_total;
    }

    public void setMontant_total(String montant_total) {
        this.montant_total = montant_total;
    }

    public Date getDate_commande() { return date_commande; }

    public void setDate_commande(Date date_commande) { this.date_commande = date_commande; }
}
