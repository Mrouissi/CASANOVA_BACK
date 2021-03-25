package com.istic.casanova.chantier;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Travaux {

    @Id
    @GeneratedValue
    @Column(name = "travaux_id")
    private Long travauxId;

    @Column(name = "date_chantier")
    private String dateChantier;

    @Column(name ="nature")
    private String nature;

    @Column(name = "dateSav")
    private String dateDebutSav;

    @Column(name = "date_contact")
    private Date dateContact;

    @Column(name = "client")
    private String nomClient;

    @Column(name = "ville")
    private String  ville;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private  String telephone;

    @Column(name = "sole_restant")
    private  String soldeRestant;

    @Column(name = "secteur")
    private String secteur;

    @Column(name = "nature_SAV")
    private String natureSav;

    @Column(name = "equipiers")
    private String equipiers;

    @Column(name = "detail_SAV")
    private String detailSav;

    @Column(name = "couplage")
    private String couplage;

    @Column(name = "fait_Le")
    private String faitLe;

    @Column(name = "intervenant_SAV")
    private String intervenantSav;

    @Column(name = "pv_motif_SAV")
    private String pvSavMotif;

    public Long getTravauxId() {
        return travauxId;
    }

    public void setTravauxId(Long travauxId) {
        this.travauxId = travauxId;
    }

    public String getDateChantier() {
        return dateChantier;
    }

    public void setDateChantier(String dateChantier) {
        this.dateChantier = dateChantier;
    }

    public String getDateDebutSav() {
        return dateDebutSav;
    }

    public void setDateDebutSav(String dateDebutSav) {
        this.dateDebutSav = dateDebutSav;
    }

    public Date getDateContact() {
        return dateContact;
    }

    public void setDateContact(Date dateContact) {
        this.dateContact = dateContact;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSoldeRestant() {
        return soldeRestant;
    }

    public void setSoldeRestant(String soldeRestant) {
        this.soldeRestant = soldeRestant;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getNatureSav() {
        return natureSav;
    }

    public void setNatureSav(String natureSav) {
        this.natureSav = natureSav;
    }

    public String getEquipiers() {
        return equipiers;
    }

    public void setEquipiers(String equipiers) {
        this.equipiers = equipiers;
    }

    public String getDetailSav() {
        return detailSav;
    }

    public void setDetailSav(String detailSav) {
        this.detailSav = detailSav;
    }

    public String getCouplage() {
        return couplage;
    }

    public void setCouplage(String couplage) {
        this.couplage = couplage;
    }

    public String getFaitLe() {
        return faitLe;
    }

    public void setFaitLe(String faitLe) {
        this.faitLe = faitLe;
    }

    public String getIntervenantSav() {
        return intervenantSav;
    }

    public void setIntervenantSav(String intervenantSav) {
        this.intervenantSav = intervenantSav;
    }

    public String getPvSavMotif() {
        return pvSavMotif;
    }

    public void setPvSavMotif(String pvSavMotif) {
        this.pvSavMotif = pvSavMotif;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}
