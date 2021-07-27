package com.istic.casanova.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BonDeCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroBDC;

    private Date Date_Commande;

    private Date Date_Reception;

    private Double metre;

    private Double remise_metre;

    private Double prixTotalHT;

    private Double prixTotalTTC;

    private Double pctVendeur1;

    private String vendeur2;

    private Double pctVendeur2;

    private String vendeur3;

    private Double pctVendeur3;


    @ManyToOne
    private Commercial commercial;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Prix prix;

    @ManyToOne
    private TVA tva;

    @ManyToOne
    private Agence agence;

    @ManyToOne
    private EntiteVente entiteVente;

    @ManyToOne
    private OrigineContact origineContact;

    @ManyToOne
    private TypesTravaux typesTravaux;

    @ManyToOne
    private ElementARenover elementARenover;

    @ManyToOne
    private PrestationARealiser prestationARealiser;

    @ManyToOne
    private SupportExistant supportExistant;

    @ManyToOne
    private ModeReglement modeReglement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroBDC() {
        return numeroBDC;
    }

    public void setNumeroBDC(String numeroBDC) {
        this.numeroBDC = numeroBDC;
    }

    public Date getDate_Commande() {
        return Date_Commande;
    }

    public void setDate_Commande(Date date_Commande) {
        Date_Commande = date_Commande;
    }

    public Date getDate_Reception() {
        return Date_Reception;
    }

    public void setDate_Reception(Date date_Reception) {
        Date_Reception = date_Reception;
    }

    public Double getMetre() {
        return metre;
    }

    public void setMetre(Double metre) {
        this.metre = metre;
    }

    public Double getRemise_metre() {
        return remise_metre;
    }

    public void setRemise_metre(Double remise_metre) {
        this.remise_metre = remise_metre;
    }

    public Double getPrixTotalHT() {
        return prixTotalHT;
    }

    public void setPrixTotalHT(Double prixTotalHT) {
        this.prixTotalHT = prixTotalHT;
    }

    public Double getPrixTotalTTC() {
        return prixTotalTTC;
    }

    public void setPrixTotalTTC(Double prixTotalTTC) {
        this.prixTotalTTC = prixTotalTTC;
    }

    public Double getPctVendeur1() {
        return pctVendeur1;
    }

    public void setPctVendeur1(Double pctVendeur1) {
        this.pctVendeur1 = pctVendeur1;
    }

    public String getVendeur2() {
        return vendeur2;
    }

    public void setVendeur2(String vendeur2) {
        this.vendeur2 = vendeur2;
    }

    public Double getPctVendeur2() {
        return pctVendeur2;
    }

    public void setPctVendeur2(Double pctVendeur2) {
        this.pctVendeur2 = pctVendeur2;
    }

    public String getVendeur3() {
        return vendeur3;
    }

    public void setVendeur3(String vendeur3) {
        this.vendeur3 = vendeur3;
    }

    public Double getPctVendeur3() {
        return pctVendeur3;
    }

    public void setPctVendeur3(Double pctVendeur3) {
        this.pctVendeur3 = pctVendeur3;
    }

    public Commercial getCommercial() {
        return commercial;
    }

    public void setCommercial(Commercial commercial) {
        this.commercial = commercial;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Prix getPrix() {
        return prix;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }

    public TVA getTva() {
        return tva;
    }

    public void setTva(TVA tva) {
        this.tva = tva;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public EntiteVente getEntiteVente() {
        return entiteVente;
    }

    public void setEntiteVente(EntiteVente entiteVente) {
        this.entiteVente = entiteVente;
    }

    public OrigineContact getOrigineContact() {
        return origineContact;
    }

    public void setOrigineContact(OrigineContact origineContact) {
        this.origineContact = origineContact;
    }

    public TypesTravaux getTypesTravaux() {
        return typesTravaux;
    }

    public void setTypesTravaux(TypesTravaux typesTravaux) {
        this.typesTravaux = typesTravaux;
    }

    public ElementARenover getElementARenover() {
        return elementARenover;
    }

    public void setElementARenover(ElementARenover elementARenover) {
        this.elementARenover = elementARenover;
    }

    public PrestationARealiser getPrestationARealiser() {
        return prestationARealiser;
    }

    public void setPrestationARealiser(PrestationARealiser prestationARealiser) {
        this.prestationARealiser = prestationARealiser;
    }

    public SupportExistant getSupportExistant() {
        return supportExistant;
    }

    public void setSupportExistant(SupportExistant supportExistant) {
        this.supportExistant = supportExistant;
    }

    public ModeReglement getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(ModeReglement modeReglement) {
        this.modeReglement = modeReglement;
    }
}
