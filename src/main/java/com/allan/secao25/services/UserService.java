package com.allan.secao25.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allan.secao25.entities.User;
import com.allan.secao25.repositories.UserRepository;

// Registrando a classe como componente do Spring, para que a injeção de dependencia funcione com @AutoWired
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
		
	/* Metodo para retornar todos os "User" no DB
	 * repassando a chamada para "repository.findAll"
	*/
	public List<User> findAll() {
		return repository.findAll();
	}
	
	// Retornando valores quando a busca é feita por Id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	// Metodo para salvar o objeto no banco
	public User insert(User obj) {
		return repository.save(obj);
	}

	// Metodo para remover usuário
	public void delete(Long id) { repository.deleteById(id); }
}
