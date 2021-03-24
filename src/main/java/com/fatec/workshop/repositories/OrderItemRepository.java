package com.fatec.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.workshop.entities.OrderItem;

//ELA TA HERDANDO DO JPAREPOSITORY E É OPCIONAL COLOCA A ANOTAION @REPOSITORY
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
