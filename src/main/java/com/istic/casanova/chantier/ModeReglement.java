package com.istic.casanova.chantier;
import javax.persistence.*;

@Entity
public class ModeReglement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ModeReglement_id")
    private Long id;

    @Column(name = "montantTTC")
    private Long montantTTC;

    @Column(name = "accompte")
    private Long accompte;

    @Column(name = "solde_de")
    private Long solde_de;

    @Column(name = "DebutTrav")
    private String  debutTrav;

    @Column(name = "recpTrav")
    private Long recepTrav;

    @Column(name = "montantfinance")
    private Long mtFinance;

    @Column(name = "mensualité_de")
    private Long mensualitéDe;

    @Column(name = "organisme")
    private String Organisme;

    @Column(name = "nombre_mois")
    private String nbMois;

    @Column(name = "taeg")
    private Integer taeg;

    @Column(name = "cout_credit")
    private Long coutCredit;

    public Long getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(Long montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Long getAccompte() {
        return accompte;
    }

    public void setAccompte(Long accompte) {
        this.accompte = accompte;
    }

    public Long getSolde_de() {
        return solde_de;
    }

    public void setSolde_de(Long solde_de) {
        this.solde_de = solde_de;
    }

    public String getDebutTrav() {
        return debutTrav;
    }

    public void setDebutTrav(String debutTrav) {
        this.debutTrav = debutTrav;
    }

    public Long getRecepTrav() {
        return recepTrav;
    }

    public void setRecepTrav(Long recepTrav) {
        this.recepTrav = recepTrav;
    }

    public Long getMtFinance() {
        return mtFinance;
    }

    public void setMtFinance(Long mtFinance) {
        this.mtFinance = mtFinance;
    }

    public Long getMensualitéDe() {
        return mensualitéDe;
    }

    public void setMensualitéDe(Long mensualitéDe) {
        this.mensualitéDe = mensualitéDe;
    }

    public String getOrganisme() {
        return Organisme;
    }

    public void setOrganisme(String organisme) {
        Organisme = organisme;
    }

    public String getNbMois() {
        return nbMois;
    }

    public void setNbMois(String nbMois) {
        this.nbMois = nbMois;
    }

    public Integer getTaeg() {
        return taeg;
    }

    public void setTaeg(Integer taeg) {
        this.taeg = taeg;
    }

    public Long getCoutCredit() {
        return coutCredit;
    }

    public void setCoutCredit(Long coutCredit) {
        this.coutCredit = coutCredit;
    }






}
