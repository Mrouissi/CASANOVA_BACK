package com.istic.casanova.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ElementARenover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom ;

    @OneToMany
    private List<PrestationARealiser> prestationARealiserList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public List<PrestationARealiser> getPrestationARealiserList() {
        return prestationARealiserList;
    }

    public void setPrestationARealiserList(List<PrestationARealiser> prestationARealiserList) {
        this.prestationARealiserList = prestationARealiserList;
    }

}
