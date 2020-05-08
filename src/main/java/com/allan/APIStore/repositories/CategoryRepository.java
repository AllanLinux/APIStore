package com.allan.APIStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allan.APIStore.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
