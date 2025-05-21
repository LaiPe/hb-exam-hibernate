package com.humanbooster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "borne_recharge")
public class BorneRecharge extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    // Le numéro physique de la borne
    private Integer num;

    @NotBlank
    private String etat;

    @NotNull
    private BigDecimal tarifHoraire;

    @NotBlank
    @Lob
    @Size(min = 50, max = 600, message = "La description doit contenir entre 50 et 600 caractères")
    @Column(length = 600, nullable = false)
    private String description;

    @Lob
    @Size(max = 1000, message = "Les instructions ne peut contenir plus de 1000 caractères")
    @Column(length = 1000)
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "lieu_id")
    LieuRecharge lieuRecharge;

    @OneToMany(targetEntity = Reservation.class, mappedBy = "borneRecharge")
    List<Reservation> reservations;

    public BorneRecharge() {
        super();
    }


    public Long getId() {
        return id;
    }

    public Integer getNum() {
        return num;
    }

    public String getEtat() {
        return etat;
    }

    public BigDecimal getTarifHoraire() {
        return tarifHoraire;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructions() {
        return instructions;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public LieuRecharge getLieuRecharge() {
        return lieuRecharge;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public void setTarifHoraire(BigDecimal tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setLieuRecharge(LieuRecharge lieuRecharge) {
        this.lieuRecharge = lieuRecharge;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void print() {
        Map<String,String> attributes = new HashMap<>();
        attributes.put("ID", getId().toString());
        //TODO NOM & ADRESSE LIEU
        attributes.put("num", getNum().toString());
        attributes.put("etat", getEtat());
        attributes.put("tarifHoraire", getTarifHoraire().toString());
        print(attributes);
    }
}
