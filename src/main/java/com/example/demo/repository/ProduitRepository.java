package com.example.demo.repository;

import com.example.demo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {
    List<Produit> findByCategoryId(UUID categoryId);
    List<Produit> findByDateExpirationBefore(LocalDate date); // Produits périmés
}