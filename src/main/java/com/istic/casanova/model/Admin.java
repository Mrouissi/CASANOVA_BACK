package com.istic.casanova.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entité Admin : Hérite de User
 */
@Entity
public class Admin extends User {

    @Column(name = "role")
    private final String role = "ROLE_ADMIN";

    public String getRole() { return role; }

}
