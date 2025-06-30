package com.example.demo.services;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit createProduit(ProduitDTO produitDTO) {
        Produit produit = new Produit();
        produit.setNomProduit(produitDTO.getNomProduit());
        produit.setPrixProduit(produitDTO.getPrixProduit());
        produit.setDateExpiration(produitDTO.getDateExpiration());
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(UUID id, ProduitDTO produitDTO) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produit non trouvé"));
        
        produit.setNomProduit(produitDTO.getNomProduit());
        produit.setPrixProduit(produitDTO.getPrixProduit());
        produit.setDateExpiration(produitDTO.getDateExpiration());
        
        return produitRepository.save(produit);
    }

    // IMPLÉMENTATION DES MÉTHODES MANQUANTES
    @Override
    public void deleteProduit(UUID id) {
        if (!produitRepository.existsById(id)) {
            throw new NotFoundException("Produit non trouvé");
        }
        produitRepository.deleteById(id);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitById(UUID id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produit non trouvé"));
    }
}