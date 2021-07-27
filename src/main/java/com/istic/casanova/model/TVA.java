package com.istic.casanova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TVA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valeurTVA;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValeurTVA() {
        return valeurTVA;
    }

    public void setValeurTVA(Double valeurTVA) {
        this.valeurTVA = valeurTVA;
    }
}
