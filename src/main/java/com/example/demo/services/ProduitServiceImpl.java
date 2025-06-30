package com.example.demo.services;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;
    private final CategoryRepository categoryRepository;
    private final DepartementRepository departementRepository;

    @Override
    public Produit createProduit(ProduitDTO produitDTO) {
        Category category = categoryRepository.findById(produitDTO.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Catégorie non trouvée"));

        Departement departement = departementRepository.findById(produitDTO.getDepartementId())
                .orElseThrow(() -> new NotFoundException("Département non trouvé"));

        Produit produit = Produit.builder()
                .nomProduit(produitDTO.getNomProduit())
                .prixProduit(produitDTO.getPrixProduit())
                .dateExpiration(produitDTO.getDateExpiration())
                .category(category)
                .departement(departement)
                .build();

        return produitRepository.save(produit);
    }

    // ... (autres méthodes)
}
