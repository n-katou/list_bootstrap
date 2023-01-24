package com.naoto.portfolio.domain.todos.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naoto.portfolio.domain.todos.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
    
}
