package com.diouf.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diouf.demo.model.Produit;
import com.diouf.demo.repository.ProduitRepository;

import lombok.Data;

@Service
@Data
public class ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	
	public Optional<Produit> getProduit(Long id) {
		
		return produitRepository.findById(id); 
	}
	
	public List<Produit> getAllProduit(){
		return produitRepository.findAll();
	}
	
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
	}
	
	public Produit ajouterProduit(Produit produit) {
		Produit ajoutProduit = produitRepository.save(produit);
		return ajoutProduit;
	}

}
