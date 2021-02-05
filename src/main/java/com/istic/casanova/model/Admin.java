package com.istic.casanova.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User {

    @Column(name = "role")
    private String role = "ROLE_ADMIN";
}
