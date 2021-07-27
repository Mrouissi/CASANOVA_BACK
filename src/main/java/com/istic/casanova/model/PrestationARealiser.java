package com.istic.casanova.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PrestationARealiser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany
    private List<SupportExistant> supportExistantList = new ArrayList<>();

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

}
