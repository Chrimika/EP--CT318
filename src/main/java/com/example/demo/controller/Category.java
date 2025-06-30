package com.example.demo.controller;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {

    @Id
    private String idCategory;

    private String nomCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Produit> produits;

    // Getters, setters ou @Data de Lombok
}
