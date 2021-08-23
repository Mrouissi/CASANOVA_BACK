package com.istic.casanova.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TypesTravaux {

    private Long id;
    private String nom;




    private List<ElementARenover> elementARenover = new ArrayList<>();
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
    public List<ElementARenover> getElementARenover() { return elementARenover; }

    public void setElementARenover(List<ElementARenover> elementARenover) {this.elementARenover = elementARenover;}

}
