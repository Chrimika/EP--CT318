package com.example.demo.repository;

import com.example.demo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {

    // Solution 1: Utilisation de la navigation de propriétés
    List<Produit> findByCategory_IdCategory(UUID categoryId);

    // Solution 2: Avec requête JPQL explicite (alternative)
    @Query("SELECT p FROM Produit p WHERE p.category.idCategory = :categoryId")
    List<Produit> findByCategoryId(@Param("categoryId") UUID categoryId);

    // Requête pour les produits périmés
    List<Produit> findByDateExpirationBefore(LocalDate date);
}