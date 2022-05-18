package com.diouf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diouf.demo.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
