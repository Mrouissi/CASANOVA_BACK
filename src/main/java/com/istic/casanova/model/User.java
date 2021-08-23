package com.istic.casanova.model;

import com.istic.casanova.validator.annotation.UniqueEmail;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

/**
 * Entité User : contient les informations de bases d'un utilisateur
 */
@Entity
@Table(name = "users")
@Inheritance(strategy= InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "tel_portable")
    private String tel_portable;

    @Column(name = "password")
    private String password;

    @UniqueEmail
    @NotBlank(message = "Email obligatoire")
    @Column(name = "email", unique = true)
    private String email;

    private boolean isEnabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String nom, String prenom, String tel_portable, String password, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel_portable = tel_portable;
        this.password = password;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean getIsEnabled() { return this.isEnabled; }
    public void setIsEnabled(boolean isEnabled) { this.isEnabled = isEnabled; }

    public String getNom() { return nom;}
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTel_portable() {return tel_portable;}
    public void setTel_portable(String tel_portable) {this.tel_portable = tel_portable;}

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() { return roles;}
    public void setRoles(Set<Role> roles) {this.roles = roles;}
}
