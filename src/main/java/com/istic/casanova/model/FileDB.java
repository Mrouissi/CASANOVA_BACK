package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class FileDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "type")
    private String type;

    @Lob
    private byte[] data;

    @ManyToOne
    @JsonBackReference
    private Dossier dossier;

    public FileDB() {

    }

    public FileDB(String nom, String type, byte[] data) {
        this.nom = nom;
        this.type = type;
        this.data = data;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public byte[] getData() { return data; }
    public void setData(byte[] data) { this.data = data; }

    @ManyToOne
    public Dossier getDossier() { return dossier; }
    public void setDossier(Dossier dossier) { this.dossier = dossier; }

}
