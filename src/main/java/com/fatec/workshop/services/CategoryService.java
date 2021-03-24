package com.fatec.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.workshop.entities.Category;
import com.fatec.workshop.repositories.CategoryRepository;

@Service //REGISTRA COMO COMPONONENTE DO SPRING PARA INJETADO AUTOMATICAMENTE PELO SPRING
public class CategoryService {
	
	@Autowired //INJEÇÃO DE DEPENDECNIA
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get(); 
	}
}
