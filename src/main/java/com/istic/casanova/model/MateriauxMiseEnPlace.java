package com.istic.casanova.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MateriauxMiseEnPlace {

    private Long id;
    private String nom;

    private List<PlusValue> plusValueList= new ArrayList<>();

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
    public List<PlusValue> getPlusValueList() {
        return plusValueList;
    }

    public void setPlusValueList(List<PlusValue> plusValueList) {
        this.plusValueList = plusValueList;
    }
}
