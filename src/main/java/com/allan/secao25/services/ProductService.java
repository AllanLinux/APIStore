package com.allan.secao25.services; // Injeção de dependencia 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allan.secao25.entities.Product;
import com.allan.secao25.repositories.ProductRepository;

//Registrando a classe como componente do Spring, para que a injeção de dependencia funcione com @AutoWired
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	/* Metodo para retornar todos os "Product" no DB
	 * repassando a chamada para "repository.findAll"
	*/
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	// Retornando valores quando a busca é feita por Id
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
