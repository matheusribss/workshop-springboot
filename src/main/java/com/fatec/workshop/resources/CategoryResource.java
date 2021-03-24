package com.fatec.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.workshop.entities.Category;
import com.fatec.workshop.services.CategoryService;


//ENDPOINT PARA BUSCAR POR CATEGORIAS
@RestController
@RequestMapping (value = "/categories")
public class CategoryResource {
	
	@Autowired //INJEÇÃO DE DEPENDENCIA AUTOMATICA DO SPRING
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity <List<Category>> FindAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
