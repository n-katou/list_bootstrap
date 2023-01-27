package com.naoto.portfolio.domain.todos.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naoto.portfolio.domain.todos.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
    
}
