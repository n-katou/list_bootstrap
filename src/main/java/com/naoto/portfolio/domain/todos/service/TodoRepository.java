package com.naoto.portfolio.domain.todos.service;

import org.springframework.data.jpa.repository.JpaRepository;


import com.naoto.portfolio.domain.todos.model.Todo;


public interface TodoRepository extends JpaRepository<Todo, Integer> {
    
}
