package com.istic.casanova.utils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.istic.casanova.model.Client;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PeriodeAbs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periode_abs_id")
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Client client;

    @Column(name = "date_debut")
    Date date_debut;

    @Column(name = "date_fin")
    Date date_fin;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @ManyToOne
    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public Date getDate_debut() { return date_debut; }

    public void setDate_debut(Date date_debut) { this.date_debut = date_debut; }

    public Date getDate_fin() { return date_fin; }

    public void setDate_fin(Date date_fin) { this.date_fin = date_fin; }
}
