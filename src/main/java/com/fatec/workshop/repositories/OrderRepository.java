package com.fatec.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.workshop.entities.Order;

//ELA TA HERDANDO DO JPAREPOSITORY E É OPCIONAL COLOCA A ANOTAION @REPOSITORY
public interface OrderRepository extends JpaRepository<Order, Long> {

}
