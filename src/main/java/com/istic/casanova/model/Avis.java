package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avis_id")
    private Long id;

    @Column(name = "note")
    private float note;

    @Column(name = "message")
    private String message;

    @JsonBackReference
    @OneToOne(targetEntity = Client.class)
    private Client client;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public float getNote() { return note; }
    public void setNote(float note) { this.note = note; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @OneToOne
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}
