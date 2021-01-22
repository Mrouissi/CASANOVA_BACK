package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends User {

    @Column(name = "civilite")
    private String civilite;

    @Column(name = "ville")
    private String ville;

    @Column(name = "codePostal")
    private String codePostal;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telFixe")
    private String telFixe;

    @Column(name = "telPortable")
    private String telPortable;

    @Column(name = "profil")
    private String profil;

    @Column(name = "profession")
    private String profession;

//    public Client(@JsonProperty("id") UUID id,
//                  @JsonProperty("nom") String nom,
//                  @JsonProperty("prenom") String prenom,
//                  @JsonProperty("civilite") String civilite,
//                  @JsonProperty("ville") String ville,
//                  @JsonProperty("codePostal") String codePostal,
//                  @JsonProperty("adresse") String adresse,
//                  @JsonProperty("mail") String mail,
//                  @JsonProperty("telFixe") String telFixe,
//                  @JsonProperty("telPortable") String telPortable,
//                  @JsonProperty("profil") String profil,
//                  @JsonProperty("profession") String profession) {
//        super(id, nom, prenom, mail);
//        this.civilite = civilite;
//        this.ville = ville;
//        this.codePostal = codePostal;
//        this.adresse = adresse;
//        this.telFixe = telFixe;
//        this.telPortable = telPortable;
//        this.profil = profil;
//        this.profession = profession;
//    }

    public Client(Client client) {
        super(client);
        this.civilite = client.getCivilite();
        this.ville = client.getVille();
        this.codePostal = client.getCodePostal();
        this.adresse = client.getAdresse();
        this.telFixe = client.getTelFixe();
        this.telPortable = client.getTelPortable();
        this.profil = client.getProfil();
        this.profession = client.getProfession();
    }

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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelFixe() {
        return telFixe;
    }

    public void setTelFixe(String telFixe) {
        this.telFixe = telFixe;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + super.getId() +
                ", nom='" + super.getNom() + '\'' +
                ", prenom='" + super.getPrenom() + '\'' +
                ", civilite='" + civilite + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", adresse='" + adresse + '\'' +
                ", mail='" + super.getMail() + '\'' +
                ", telFixe='" + telFixe + '\'' +
                ", telPortable='" + telPortable + '\'' +
                ", profil='" + profil + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
