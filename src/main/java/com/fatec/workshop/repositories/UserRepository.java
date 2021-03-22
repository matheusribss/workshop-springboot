package com.fatec.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.workshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
