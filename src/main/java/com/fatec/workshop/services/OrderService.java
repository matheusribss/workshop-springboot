package com.fatec.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.workshop.entities.Order;
import com.fatec.workshop.repositories.OrderRepository;

@Service //REGISTRA COMO COMPONONENTE DO SPRING PARA INJETADO AUTOMATICAMENTE PELO SPRING
public class OrderService {
	
	@Autowired //INJEÇÃO DE DEPENDECNIA
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); 
	}
}
