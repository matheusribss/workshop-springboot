package com.fatec.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.workshop.entities.Order;

//PARA SALVAR NO BANCO DE DADOS PRECISA DESSA CLASSE REPOSITORIE

//ELA TA HERDANDO DO JPAREPOSITORY E É OPCIONAL COLOCA A ANOTAION @REPOSITORY
public interface OrderRepository extends JpaRepository<Order, Long> {

}
