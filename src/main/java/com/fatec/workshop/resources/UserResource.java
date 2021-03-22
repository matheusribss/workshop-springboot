package com.fatec.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
