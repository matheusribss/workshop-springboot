package com.fatec.workshop.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fatec.workshop.entities.User;
import com.fatec.workshop.repositories.UserRepository;
import com.fatec.workshop.services.exceptions.DatabaseException;
import com.fatec.workshop.services.exceptions.ResourceNotFoundException;

@Service //REGISTRA COMO COMPONONENTE DO SPRING PARA INJETADO AUTOMATICAMENTE PELO SPRING
public class UserService {
	
	@Autowired //INJEÇÃO DE DEPENDECNIA
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		try {
		repository.deleteById(id);
		}catch ( EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
		User entity = repository.getOne(id);//MAIS EFICIENTE QUE O FINDBYID
		updateData(entity, obj);
		return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
