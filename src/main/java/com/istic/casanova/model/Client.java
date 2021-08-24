package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Entité Client : Hérite de User
 */
@Entity
public class Client extends User {

    @Column(name = "civilite")
    private String civilite;

    @Column(name = "ville")
    private String ville;

    @Column(name = "code_postal")
    private String code_postal;

    @Column(name ="departement")
    private String dpt;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "tel_fixe")
    private String tel_fixe;



    @ManyToOne
    private Commercial commercial;


    @OneToMany(mappedBy = "client")
    private List<BonDeCommande> bonDeCommandeList = new ArrayList<>();

    /**
     * Dossier lié au client
     */
    @OneToMany(mappedBy = "client")
    @JsonManagedReference(value = "client_dossier")
    private List<Dossier> dossiers = new ArrayList<>();

    /**
     * Périodes d'abscences liées au Client
     */

    @OneToMany(mappedBy = "client")
    @JsonManagedReference(value = "client_abs")
    private List<PeriodeAbs> periodes_abs;

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel_fixe() {
        return tel_fixe;
    }

    public void setTel_fixe(String tel_fixe) {
        this.tel_fixe = tel_fixe;
    }

    public String getDpt() {return dpt;}

    public void setDpt(String dpt) {this.dpt = dpt;}


    @OneToMany(mappedBy = "client")
    public List<Dossier> getDossiers() {
        return dossiers;
    }
    public void setDossiers(List<Dossier> dossiers) { this.dossiers = dossiers; }

    public List<PeriodeAbs> getPeriodes_abs() { return periodes_abs; }
    public void setPeriodes_abs(List<PeriodeAbs> periodes_abs) { this.periodes_abs = periodes_abs; }


    public Commercial getCommercial() {
        return commercial;
    }

    public void setCommercial(Commercial commercial) {
        this.commercial = commercial;
    }


    public List<BonDeCommande> getBonDeCommandeList() {
        return bonDeCommandeList;
    }

    public void setBonDeCommandeList(List<BonDeCommande> bonDeCommandeList) {
        this.bonDeCommandeList = bonDeCommandeList;
    }
}
