package com.naoto.portfolio.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.naoto.portfolio.app.service.TodoService;
import com.naoto.portfolio.domain.todos.model.Todo;

@Controller
public class TodoController {
    
    @Autowired
    TodoService todoService;
   
    @GetMapping("/todos")
    public String index(Model model) {
        List<Todo> allTodo = todoService.searchAll();
        model.addAttribute("allTodo", allTodo);
        return "/todos/index";
    }

}