package com.allan.secao25.services;	// Injeção de dependencia 


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allan.secao25.entities.Category;
import com.allan.secao25.repositories.CategoryRepository;

//Registrando a classe como componente do Spring, para que a injeção de dependencia funcione com @AutoWired
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	/* Metodo para retornar todos os "Category" no DB
	 * repassando a chamada para "repository.findAll"
	*/
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	// Retornando valores quando a busca é feita por Id
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
