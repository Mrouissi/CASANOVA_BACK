package com.istic.casanova.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PrestationARealiser {


    private Long id;
    private String nom;
    private List<SupportExistant> supportExistantList = new ArrayList<>();

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
    public List<SupportExistant> getSupportExistantList() {
        return supportExistantList;
    }

    public void setSupportExistantList(List<SupportExistant> supportExistantList) {
        this.supportExistantList = supportExistantList;
    }
}
