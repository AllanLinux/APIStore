package com.allan.APIStore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allan.APIStore.entities.Category;
import com.allan.APIStore.services.CategoryService;

//Determina que a classe terá um controlador rest
@RestController
//Determinando o path da rest
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	// GetMapping para indicar que este método que responde a requisição do tipo GET do HTTP
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		
		// Criando uma lista e chamando o findAll criado na classe CategoryService
		List<Category> list = service.findAll();
		// O "ok" para retornar resposta com sucesso e body para retornar o corpo do resposta 
		return ResponseEntity.ok().body(list);
	}
	// Endpoint para buscar usuario pelo id
		@GetMapping(value = "/{id}")
		// @PathVariable é usado quando o valor da variavel é passado diretamente na URL
		// Ex: http://localhost:8080/category/1
		public ResponseEntity<Category> findByAll(@PathVariable Long id) {
			Category obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
	

}
