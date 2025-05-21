package com.humanbooster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "lieu_recharge")
public class LieuRecharge extends GenericEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100, message = "Le nom du lieu de recharge ne doit pas dépasser 200 caractères")
    @Column(length = 100, nullable = false)
    private String nom;

    @NotBlank
    @Size(max = 300, message = "L'adresse du lieu de recharge ne doit pas dépasser 300 caractères")
    @Column(length = 300, nullable = false)
    private String adresse;

    @OneToMany(targetEntity = BorneRecharge.class, mappedBy = "lieuRecharge")
    List<BorneRecharge> bornes;

    public LieuRecharge() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void print() {
        Map<String,String> attributes = new HashMap<>();
        attributes.put("ID", getId().toString());
        attributes.put("nom", getNom());
        attributes.put("adresse", getAdresse());
        print(attributes);
    }
}
