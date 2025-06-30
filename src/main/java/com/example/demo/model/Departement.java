package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "departements")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Departement {

    @Id
    @GeneratedValue
    private UUID idDepartement;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Le nom du département est obligatoire")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    private String nomDepartement;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Produit> produits;
}