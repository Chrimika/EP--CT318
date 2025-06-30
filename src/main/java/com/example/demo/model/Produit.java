package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "produits")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue
    private UUID idProduit;

    @Column(nullable = false)
    @NotBlank(message = "Le nom du produit est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    private String nomProduit;

    @Column(nullable = false)
    @PositiveOrZero(message = "Le prix doit être positif ou zéro")
    private Integer prixProduit;

    @Column(nullable = false)
    @Future(message = "La date d'expiration doit être dans le futur")
    private LocalDate dateExpiration;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    @NotNull(message = "La catégorie est obligatoire")
    private Category category;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departement_id")
    @NotNull(message = "Le département est obligatoire")
    private Departement departement;
}
