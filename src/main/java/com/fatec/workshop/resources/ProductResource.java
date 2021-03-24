package com.fatec.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.workshop.entities.Product;
import com.fatec.workshop.services.ProductService;

@RestController
@RequestMapping (value = "/products")
public class ProductResource {
	
	@Autowired //INJEÇÃO DE DEPENDENCIA AUTOMATICA DO SPRING
	private ProductService service;
	
	@GetMapping
	public ResponseEntity <List<Product>> FindAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
