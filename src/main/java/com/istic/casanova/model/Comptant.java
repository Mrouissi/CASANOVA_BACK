package com.istic.casanova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comptant extends ModeReglement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montantTTC;

    private Double acompte;

    private Double soldeDe;

    private Date dateEncaissemnt;

    private Long nbReglement;

    private Double cdt;

    private Double cdr;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(Double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Double getAcompte() {
        return acompte;
    }

    public void setAcompte(Double acompte) {
        this.acompte = acompte;
    }

    public Double getSoldeDe() {
        return soldeDe;
    }

    public void setSoldeDe(Double soldeDe) {
        this.soldeDe = soldeDe;
    }

    public Date getDateEncaissemnt() {
        return dateEncaissemnt;
    }

    public void setDateEncaissemnt(Date dateEncaissemnt) {
        this.dateEncaissemnt = dateEncaissemnt;
    }

    public Long getNbReglement() {
        return nbReglement;
    }

    public void setNbReglement(Long nbReglement) {
        this.nbReglement = nbReglement;
    }

    public Double getCdt() {
        return cdt;
    }

    public void setCdt(Double cdt) {
        this.cdt = cdt;
    }

    public Double getCdr() {
        return cdr;
    }

    public void setCdr(Double cdr) {
        this.cdr = cdr;
    }
}
