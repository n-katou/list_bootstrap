package com.naoto.portfolio.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naoto.portfolio.domain.todos.model.Todo;
import com.naoto.portfolio.domain.todos.service.TodoRepository;

@Service
public class TodoService {
    
    @Autowired
    TodoRepository todoRepository;

    public List<Todo> searchAll() {
        return todoRepository.findAll();
    }
}
