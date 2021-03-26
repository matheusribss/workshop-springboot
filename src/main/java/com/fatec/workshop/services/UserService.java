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
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);//MAIS EFICIENTE QUE O FINDBYID
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
