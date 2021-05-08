package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Entité PeriodeAbs : Permet de déclarer une période entre deux dates dans laquelle le client n'est pas disponible.
 */
@Entity
public class PeriodeAbs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periode_abs_id")
    private Long id;

    /**
     * Client lié
     */
    @ManyToOne
    @JsonBackReference(value = "client_abs")
    private Client client;

    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd/MM/yyyy")
    Date date_debut;

    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd/MM/yyyy")
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
