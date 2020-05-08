package com.allan.APIStore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allan.APIStore.entities.User;
import com.allan.APIStore.repositories.UserRepository;

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

	// Metodo para atualizar os dados do usuário, recebendo o id do usuário que irá atualizar e também o objeto user contendo os dados a serem atualizados
	public User update(Long id, User obj) {
		// GetOne irá instancia o usuario, carregado na memória para trabalhar com ele antes de acessar o DB
		User entity = repository.getOne(id);
		// Atualizando os dados do entity baseado nos dados recebeidos do obj
		updateData(entity, obj);
		return repository.save(entity);
	}
	// Esse metodo recebe do obj e os seta com os novos
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
