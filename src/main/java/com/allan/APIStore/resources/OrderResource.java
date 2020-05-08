package com.allan.APIStore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allan.APIStore.entities.Order;
import com.allan.APIStore.services.OrderService;

// Determina que a classe terá um controlador rest
@RestController
// Determinando o path da rest
@RequestMapping(value = "/orders")
public class OrderResource {
	
	// Injeção de dependencia 
	@Autowired
	private OrderService service;
	
	// GetMapping para indicar que este método que responde a requisição do tipo GET do HTTP
	@GetMapping
	// Metodo será um Endpoint para acessar os usuários, retornará uma lista do tipo Order, implementada na classe OrderService
	public ResponseEntity<List<Order>> findAll() {
		
		// Criando uma lista e chamando o findAll criado na classe OrderService
		List<Order> list = service.findAll();
		// O "ok" para retornar resposta com sucesso e body para retornar o corpo do resposta 
		return ResponseEntity.ok().body(list);
	}
	// Endpoint para buscar usuario pelo id
	@GetMapping(value = "/{id}")
	// @PathVariable é usado quando o valor da variavel é passado diretamente na URL
	// Ex: http://localhost:8080/Orders/1
	public ResponseEntity<Order> findByAll(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
