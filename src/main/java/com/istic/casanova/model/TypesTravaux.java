package com.istic.casanova.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TypesTravaux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany
    private List<ElementARenover> elementARenoverList= new ArrayList<>();

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

    public List<ElementARenover> getElementARenoverList() {
        return elementARenoverList;
    }

    public void setElementARenoverList(List<ElementARenover> elementARenoverList) {
        this.elementARenoverList = elementARenoverList;
    }
}
