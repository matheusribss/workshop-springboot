package com.fatec.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.workshop.entities.User;
import com.fatec.workshop.repositories.UserRepository;

@Service //REGISTRA COMO COMPONONENTE DO SPRING PARA INJETADO AUTOMATICAMENTE PELO SPRING
public class UserService {
	
	@Autowired //INJEÇÃO DE DEPENDECNIA
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); 
	}
}
