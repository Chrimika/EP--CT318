package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDTO {
    private UUID idProduit;

    @NotBlank(message = "Le nom du produit est obligatoire")
    @Size(min = 2, max = 100)
    private String nomProduit;

    @PositiveOrZero(message = "Le prix doit être positif")
    private Integer prixProduit;

    @Future(message = "La date d'expiration doit être dans le futur")
    private LocalDate dateExpiration;

    @NotNull(message = "La catégorie est requise")
    private UUID categoryId;

    @NotNull(message = "Le département est requis")
    private UUID departementId;
}