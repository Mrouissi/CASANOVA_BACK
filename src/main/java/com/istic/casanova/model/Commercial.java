package com.istic.casanova.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Commercial extends User {

    @Column(name = "role")
    private String role = "ROLE_COMMERCIAL";

}
