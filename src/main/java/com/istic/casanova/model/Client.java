package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client extends User {

    @Column(name = "civilite")
    private String civilite;

    @Column(name = "ville")
    private String ville;

    @Column(name = "code_postal")
    private String code_postal;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "tel_fixe")
    private String tel_fixe;

    @Column(name = "tel_portable")
    private String telPortable;

    @Column(name = "profil")
    private String profil;

    @Column(name = "profession")
    private String profession;

    @Column(name = "role")
    private final String role = "ROLE_CLIENT";

    @JsonManagedReference
    private List<Dossier> dossiers;

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

    public String getTelPortable() {
        return telPortable;
    }

    public void setTelPortable(String telPortable) {
        this.telPortable = telPortable;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRole() { return role; }

    @OneToMany(mappedBy = "client")
    public List<Dossier> getDossiers() {
        return dossiers;
    }

    public void setDossiers(List<Dossier> dossiers) { this.dossiers = dossiers; }
}
