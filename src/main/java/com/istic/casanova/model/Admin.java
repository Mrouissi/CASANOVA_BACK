package com.istic.casanova.model;

import javax.persistence.Entity;

/**
 * Entité Admin : Hérite de User
 */
@Entity
public class Admin extends User {


    public Admin (){super();}

    public Admin(String password){
        this.setPassword(password);
    }


}
