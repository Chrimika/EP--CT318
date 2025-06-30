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
    @GeneratedValue(strategy = GenerationType.UUID)
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
    @JoinColumn(name = "category_id", referencedColumnName = "id_category")
    @NotNull(message = "La catégorie est obligatoire")
    private Category category;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departement_id", referencedColumnName = "id_departement")
    @NotNull(message = "Le département est obligatoire")
    private Departement departement;

    // Méthode helper pour accéder à l'ID de la catégorie
    public UUID getCategoryId() {
        return this.category != null ? this.category.getIdCategory() : null;
    }

    // Méthode helper pour accéder à l'ID du département
    public UUID getDepartementId() {
        return this.departement != null ? this.departement.getIdDepartement() : null;
    }
}