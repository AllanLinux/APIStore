package com.allan.APIStore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allan.APIStore.entities.Order;
import com.allan.APIStore.repositories.OrderRepository;

// Registrando a classe como componente do Spring, para que a injeção de dependencia funcione com @AutoWired
@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
		
	/* Metodo para retornar todos os "User" no DB
	 * repassando a chamada para "repository.findAll"
	*/
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
