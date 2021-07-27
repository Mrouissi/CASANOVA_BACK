package com.istic.casanova.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Financement extends ModeReglement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrganismeFinancement organismeFinancement;

    private Date DateOffre;

    private Double montantFinance;

    private Double duree;

    private Double taux;

    private Double coutVendeur;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public OrganismeFinancement getOrganismeFinancement() {
        return organismeFinancement;
    }

    public void setOrganismeFinancement(OrganismeFinancement organismeFinancement) {
        this.organismeFinancement = organismeFinancement;
    }

    public Date getDateOffre() {
        return DateOffre;
    }

    public void setDateOffre(Date dateOffre) {
        DateOffre = dateOffre;
    }

    public Double getMontantFinance() {
        return montantFinance;
    }

    public void setMontantFinance(Double montantFinance) {
        this.montantFinance = montantFinance;
    }

    public Double getDuree() {
        return duree;
    }

    public void setDuree(Double duree) {
        this.duree = duree;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public Double getCoutVendeur() {
        return coutVendeur;
    }

    public void setCoutVendeur(Double coutVendeur) {
        this.coutVendeur = coutVendeur;
    }


}
