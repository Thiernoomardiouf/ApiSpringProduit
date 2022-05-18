package com.diouf.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.diouf.demo.model.Produit;
import com.diouf.demo.repository.ProduitRepository;

@SpringBootTest
class ApiSpringApplicationTests {
	
	@Autowired
	private ProduitRepository produitRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testAjoutProduit() {
		Produit p = new Produit();
		p.setLibele("Ordinateur HP");
		p.setQuantite(30);
		produitRepository.save(p);
	}
	
	@Test
	public void testGetProduit() {
		Produit p = produitRepository.findById(1L).get(); 
		System.out.println(p);
	}
	
	@Test
	public void testAllProduit() {
		List<Produit> list = produitRepository.findAll();
		for (Produit produit : list) {
			System.out.println(produit);
		}
	}
	
	@Test
	public void testModifierProduit() {
		Produit p = produitRepository.findById(2L).get();
		p.setQuantite(60);
		produitRepository.save(p);
	}

}
