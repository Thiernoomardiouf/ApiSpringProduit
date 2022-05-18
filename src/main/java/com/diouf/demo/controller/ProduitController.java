package com.diouf.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diouf.demo.model.Produit;
import com.diouf.demo.service.ProduitService;

@RestController
public class ProduitController {
	
	@Autowired
	private ProduitService produitService;
	
	@GetMapping("/produit") 
	public Iterable<Produit> getProduits(){
		return produitService.getAllProduit(); 
	} 
	
	@PostMapping("/produit")
    public Produit creerProduit(@RequestBody Produit produit) {
		return produitService.ajouterProduit(produit);
	}
	
	@GetMapping("/produit/{id}")
	public Produit getProduit(@PathVariable("id") Long id) {
		Optional<Produit> produit = produitService.getProduit(id);
		if(produit.isPresent()) {
			return produit.get();
		}else
		{
			return null;
		}
	}
	
	@DeleteMapping("/produit/{id}")
	public void deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteProduit(id);
	}
	
	@PutMapping("/produit/{id}")
	public Produit updateProduit(@PathVariable("id") Long id, @RequestBody Produit produit) {
		Optional<Produit> p = produitService.getProduit(id);
		if(p.isPresent()) {
			Produit currentProduit = p.get();
			
			String libele = produit.getLibele();
			if(libele != null) {
				currentProduit.setLibele(libele);
			}
			int quantite = produit.getQuantite();
			if(quantite != 0) {
				currentProduit.setQuantite(quantite);
			}
			produitService.ajouterProduit(currentProduit);
			return currentProduit;
		} else {
			return null;
		}
	}
	
}
