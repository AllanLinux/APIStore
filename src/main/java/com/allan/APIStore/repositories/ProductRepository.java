package com.allan.APIStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allan.APIStore.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
