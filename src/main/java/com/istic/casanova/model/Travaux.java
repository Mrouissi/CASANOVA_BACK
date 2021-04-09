package com.istic.casanova.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Travaux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travaux_id")
    private Long id;

    @ManyToOne
    @JsonBackReference(value = "chantier_travaux")
    private Chantier chantier;

    @Column(name = "type_travaux")
    private String type_travaux;

    @Column(name = "elem_renov")
    private String elem_renov;

    @Column(name = "prestation")
    private String prestation;

    @Column(name = "support_existant")
    private String support_existant;

    @Column(name = "remise_metre")
    private String remise_metre;

    @Column(name = "prix_metre_carre_ht")
    private String prix_metre_carre_ht;

    @Column(name = "prix_total_ht")
    private String prix_total_ht;

    /* Getters and Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    public String getType_travaux() {
        return type_travaux;
    }

    public void setType_travaux(String type_travaux) {
        this.type_travaux = type_travaux;
    }

    public String getElem_renov() {
        return elem_renov;
    }

    public void setElem_renov(String elem_renov) {
        this.elem_renov = elem_renov;
    }

    public String getPrestation() {
        return prestation;
    }

    public void setPrestation(String prestation) {
        this.prestation = prestation;
    }

    public String getSupport_existant() {
        return support_existant;
    }

    public void setSupport_existant(String support_existant) {
        this.support_existant = support_existant;
    }

    public String getRemise_metre() {
        return remise_metre;
    }

    public void setRemise_metre(String remise_metre) {
        this.remise_metre = remise_metre;
    }

    public String getPrix_metre_carre_ht() {
        return prix_metre_carre_ht;
    }

    public void setPrix_metre_carre_ht(String prix_metre_carre_ht) {
        this.prix_metre_carre_ht = prix_metre_carre_ht;
    }

    public String getPrix_total_ht() {
        return prix_total_ht;
    }

    public void setPrix_total_ht(String prix_total_ht) {
        this.prix_total_ht = prix_total_ht;
    }
}
