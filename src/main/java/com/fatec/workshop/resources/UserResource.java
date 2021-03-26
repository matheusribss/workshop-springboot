package com.fatec.workshop.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.workshop.entities.User;
import com.fatec.workshop.services.UserService;

@RestController
@RequestMapping (value = "/users")
public class UserResource {
	
	@Autowired //INJEÇÃO DE DEPENDENCIA AUTOMATICA DO SPRING
	private UserService service;
	
	@GetMapping
	public ResponseEntity <List<User>> FindAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//ENDPOINT , USANDO O GET PARA RECUPERAR USUARIO DO BANCO DE DADOS
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
}
