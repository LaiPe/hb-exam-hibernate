package com.humanbooster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @PastOrPresent
    private LocalDate dateDebut;

    @NotNull
    //TODO decorateur custom assert dateFin after dateDebut
    private LocalDate dateFin;

    @NotBlank
    private String statut;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "borne_id")
    private BorneRecharge borneRecharge;


    public Reservation() {
        super();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public String getStatut() {
        return statut;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
