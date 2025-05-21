package com.humanbooster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100, message = "Le nom de l'utilisateur ne doit pas dépasser 100 caractères")
    @Column(length = 100, nullable = false)
    private String nom;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String motDePasse;

    private String codeValidation;

    private boolean valide;

    @NotBlank
    private String role;

    @OneToMany(targetEntity = Reservation.class, mappedBy = "utilisateur")
    List<Reservation> reservations;

    public Utilisateur() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getCodeValidation() {
        return codeValidation;
    }

    public boolean isValide() {
        return valide;
    }

    public String getRole() {
        return role;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setCodeValidation(String codeValidation) {
        this.codeValidation = codeValidation;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void print() {
        Map<String,String> attributes = new HashMap<>();
        attributes.put("ID", getId().toString());
        attributes.put("nom", getNom());
        attributes.put("email", getEmail());
        attributes.put("role", getRole());
        print(attributes);
    }
}

