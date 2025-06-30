package com.example.demo.services;
import java.util.UUID;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.model.Produit;
import java.util.List;

public interface ProduitService {
    Produit createProduit(ProduitDTO produitDTO);
    Produit updateProduit(UUID id, ProduitDTO produitDTO);
    void deleteProduit(UUID id);
    List<Produit> getAllProduits();
    Produit getProduitById(UUID id);
}
