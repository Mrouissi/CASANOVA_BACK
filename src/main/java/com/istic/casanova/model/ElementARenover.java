package com.istic.casanova.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ElementARenover {


    private Long id;

    private String nom ;

    private List<PrestationARealiser> prestationARealiserList = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany
    public List<PrestationARealiser> getPrestationARealiserList() {
        return prestationARealiserList;
    }

    public void setPrestationARealiserList(List<PrestationARealiser> prestationARealiserList) {
        this.prestationARealiserList = prestationARealiserList;
    }


}
