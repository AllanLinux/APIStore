package com.allan.secao25.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allan.secao25.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
