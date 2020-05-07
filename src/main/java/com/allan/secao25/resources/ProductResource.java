package com.allan.secao25.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allan.secao25.entities.Product;
import com.allan.secao25.services.ProductService;

// Determina que a classe terá um controlador rest
@RestController
// Determinando o path da rest
@RequestMapping(value = "/products")
public class ProductResource {
	
	// Injeção de dependencia 
	@Autowired
	private ProductService service;
	
	// GetMapping para indicar que este método que responde a requisição do tipo GET do HTTP
	@GetMapping
	// Metodo será um Endpoint para acessar os usuários, retornará uma lista do tipo product, implementada na classe productService
	public ResponseEntity<List<Product>> findAll() {
		
		// Criando uma lista e chamando o findAll criado na classe productService
		List<Product> list = service.findAll();
		// O "ok" para retornar resposta com sucesso e body para retornar o corpo do resposta 
		return ResponseEntity.ok().body(list);
	}
	// Endpoint para buscar usuario pelo id
	@GetMapping(value = "/{id}")
	// @PathVariable é usado quando o valor da variavel é passado diretamente na URL
	// Ex: http://localhost:8080/products/1
	public ResponseEntity<Product> findByAll(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
