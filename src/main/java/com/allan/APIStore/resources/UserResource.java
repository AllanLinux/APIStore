package com.allan.APIStore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import com.allan.APIStore.entities.User;
import com.allan.APIStore.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Determina que a classe terá um controlador rest
@RestController
// Determinando o path da rest
@RequestMapping(value = "/users")
public class UserResource {
	
	// Injeção de dependencia 
	@Autowired
	private UserService service;
	
	// GetMapping para indicar que este método que responde a requisição do tipo GET do HTTP
	@GetMapping
	// Metodo será um Endpoint para acessar os usuários, retornará uma lista do tipo User, implementada na classe UserService
	public ResponseEntity<List<User>> findAll() {
		
		// Criando uma lista e chamando o findAll criado na classe UserService
		List<User> list = service.findAll();
		// O "ok" para retornar resposta com sucesso e body para retornar o corpo do resposta 
		return ResponseEntity.ok().body(list);
	}
	// Endpoint para buscar usuario pelo id
	@GetMapping(value = "/{id}")
	// @PathVariable é usado quando o valor da variavel é passado diretamente na URL
	// Ex: http://localhost:8080/users/1
	public ResponseEntity<User> findByAll(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Metodo POST para inserir usuário
	@PostMapping
	// RequestBody para fazer a ligação do corpo da solicitação com o parametro do metodo
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		// Aqui, faço que o método retorne um 201 (Boas praticas do Http) e retorne o id criado no header
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	// Metodo delete para remover usuario do banco
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) { 
		service.delete(id);
		// Retorna uma resposta vazia e seu status é 204 pelas boas praticas do http
		return ResponseEntity.noContent().build();
	}

	// Metodo para atualizar os dados do usuário
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
