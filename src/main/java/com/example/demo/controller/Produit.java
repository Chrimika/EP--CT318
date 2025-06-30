package com.example.demo.controller;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Produit {

    @Id
    @GeneratedValue
    private UUID idProduit;

    private String nomProduit;

    private Integer prixProduit;

    private LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    // Getters, setters ou @Data
}
