package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.istic.casanova.utils.Utils;
import com.istic.casanova.utils.enums.Etat.EtatAcompte;
import com.istic.casanova.utils.enums.Etat.EtatDossier;
import com.istic.casanova.utils.enums.Etat.EtatSAV;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Client lié au dossier
     */
    @ManyToOne
    @JsonBackReference(value = "client_dossier")
    private Client client;

    /**
     * Fichiers lié au dossier
     */
    @JsonManagedReference
    @ElementCollection(targetClass=FileDB.class)
    private List<FileDB> files;

    /**
     * Infos chantier lié au dossier
     */
    @OneToOne
    @JsonManagedReference(value = "dossier_chantier")
    private Chantier chantier;

    /* Etat avancement */

    @Enumerated(EnumType.STRING)
    private EtatDossier etat_dossier;

    @Enumerated(EnumType.STRING)
    private EtatAcompte etat_acompte;

    @Enumerated(EnumType.STRING)
    private EtatSAV etat_sav;

    @Column(name = "msg_sav")
    private String msg_sav;

    /* Infos */

    @Column(name = "agence")
    private String agence;

    @Column(name = "entite_vente")
    private String entite_vente;

    @Column(name = "num_bon")
    private String num_bon;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_commande")
    private Date date_commande;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_reception")
    private Date date_reception;

    @Column(name = "tva")
    private String tva = Utils.TVA;

    @Column(name = "total_ttc")
    private String total_ttc;

    /* Comptant */

    @Column(name = "montant_ttc")
    private String montant_ttc;

    @Column(name = "montant_acompte")
    private String montant_acompte;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_encaissement")
    private Date date_encaissement;

    @Column(name = "solde")
    private String solde;

    @Column(name = "nb_reglement")
    private String nb_reglement;

    @Column(name = "CDT")
    private String CDT;

    @Column(name = "CDR")
    private String CDR;

    /* Financement */

    @Column(name = "organisme")
    private String organisme;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_offre")
    private Date date_offre;

    @Column(name = "montant_finance")
    private String montant_finance;

    @Column(name = "duree")
    private String duree;

    @Column(name = "taux")
    private String taux;

    @Column(name = "cout_vendeur")
    private String cout_vendeur;

    /* Vendeurs */

    @Column(name = "vendeur1")
    private String vendeur1;

    @Column(name = "pct_vendeur1")
    private String pct_vendeur1;

    @Column(name = "vendeur2")
    private String vendeur2;

    @Column(name = "pct_vendeur2")
    private String pct_vendeur2;

    @Column(name = "vendeur3")
    private String vendeur3;

    @Column(name = "pct_vendeur3")
    private String pct_vendeur3;

    /* Getters & Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @OneToMany(mappedBy = "dossier")
    public List<FileDB> getFiles() {
        return files;
    }

    public void setFiles(List<FileDB> files) {
        this.files = files;
    }

    public void addFile(FileDB fileDB) {this.files.add(fileDB);}

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    public EtatDossier getEtat_dossier() {
        return etat_dossier;
    }

    public void setEtat_dossier(EtatDossier etat_dossier) {
        this.etat_dossier = etat_dossier;
    }

    public EtatAcompte getEtat_acompte() {
        return etat_acompte;
    }

    public void setEtat_acompte(EtatAcompte etat_acompte) {
        this.etat_acompte = etat_acompte;
    }

    public EtatSAV getEtat_sav() {
        return etat_sav;
    }

    public void setEtat_sav(EtatSAV etat_sav) {
        this.etat_sav = etat_sav;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public String getEntite_vente() {
        return entite_vente;
    }

    public void setEntite_vente(String entite_vente) {
        this.entite_vente = entite_vente;
    }

    public String getNum_bon() {
        return num_bon;
    }

    public void setNum_bon(String num_bon) {
        this.num_bon = num_bon;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public Date getDate_reception() {
        return date_reception;
    }

    public void setDate_reception(Date date_reception) {
        this.date_reception = date_reception;
    }

    public String getMontant_ttc() {
        return montant_ttc;
    }

    public void setMontant_ttc(String montant_ttc) {
        this.montant_ttc = montant_ttc;
    }

    public String getMontant_acompte() {
        return montant_acompte;
    }

    public void setMontant_acompte(String montant_acompte) {
        this.montant_acompte = montant_acompte;
    }

    public Date getDate_encaissement() {
        return date_encaissement;
    }

    public void setDate_encaissement(Date date_encaissement) {
        this.date_encaissement = date_encaissement;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public String getNb_reglement() {
        return nb_reglement;
    }

    public void setNb_reglement(String nb_reglement) {
        this.nb_reglement = nb_reglement;
    }

    public String getCDT() {
        return CDT;
    }

    public void setCDT(String CDT) {
        this.CDT = CDT;
    }

    public String getCDR() {
        return CDR;
    }

    public void setCDR(String CDR) {
        this.CDR = CDR;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public Date getDate_offre() {
        return date_offre;
    }

    public void setDate_offre(Date date_offre) {
        this.date_offre = date_offre;
    }

    public String getMontant_finance() {
        return montant_finance;
    }

    public void setMontant_finance(String montant_finance) {
        this.montant_finance = montant_finance;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getTaux() {
        return taux;
    }

    public void setTaux(String taux) {
        this.taux = taux;
    }

    public String getCout_vendeur() {
        return cout_vendeur;
    }

    public void setCout_vendeur(String cout_vendeur) {
        this.cout_vendeur = cout_vendeur;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public String getTotal_ttc() {
        return total_ttc;
    }

    public void setTotal_ttc(String total_ttc) {
        this.total_ttc = total_ttc;
    }

    public String getVendeur1() {
        return vendeur1;
    }

    public void setVendeur1(String vendeur1) {
        this.vendeur1 = vendeur1;
    }

    public String getPct_vendeur1() {
        return pct_vendeur1;
    }

    public void setPct_vendeur1(String pct_vendeur1) {
        this.pct_vendeur1 = pct_vendeur1;
    }

    public String getVendeur2() {
        return vendeur2;
    }

    public void setVendeur2(String vendeur2) {
        this.vendeur2 = vendeur2;
    }

    public String getPct_vendeur2() {
        return pct_vendeur2;
    }

    public void setPct_vendeur2(String pct_vendeur2) {
        this.pct_vendeur2 = pct_vendeur2;
    }

    public String getVendeur3() {
        return vendeur3;
    }

    public void setVendeur3(String vendeur3) {
        this.vendeur3 = vendeur3;
    }

    public String getPct_vendeur3() {
        return pct_vendeur3;
    }

    public void setPct_vendeur3(String pct_vendeur3) {
        this.pct_vendeur3 = pct_vendeur3;
    }
}
