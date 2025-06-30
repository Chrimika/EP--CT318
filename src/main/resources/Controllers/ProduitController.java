package com.example.demo.controller;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.model.Produit;
import com.example.demo.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @PostMapping
    public ResponseEntity<Produit> createProduit(@Valid @RequestBody ProduitDTO produitDTO) {
        Produit produit = produitService.createProduit(produitDTO);
        return ResponseEntity.ok(produit);
    }

    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        return ResponseEntity.ok(produitService.getAllProduits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable UUID id) {
        return ResponseEntity.ok(produitService.getProduitById(id));
    }
}