package com.naoto.portfolio.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.naoto.portfolio.app.service.TodoService;
import com.naoto.portfolio.domain.todos.model.Todo;

@Controller
public class TodoController {
    
    @Autowired
    TodoService todoService;
   
    @GetMapping("/todos")
    public String index(@ModelAttribute Todo todo, Model model) {
        model.addAttribute("allTodo", todoService.searchAll());
        return "todos/index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("todo", todoService.findById(id));
        return "todos/show";
    }

    @PostMapping("/create")
    public String createTodo(@Validated @ModelAttribute Todo todo, BindingResult bindingResult,Model model ) {

        if(bindingResult.hasErrors()){
            model.addAttribute("allTodo", todoService.searchAll());
            return "todos/index";
        }
        todoService.addTodo(todo);
        return "redirect:/todos";
    }

    @PostMapping("/done")
    public String doneTodo(@RequestParam(name = "id") Integer todoId) {
        Todo updaTodo = todoService.findById(todoId);
        updaTodo.setDone(true);
        todoService.addTodo(updaTodo);
        return "redirect:/todos";
    }

    @PostMapping("/notdone")
    public String notdoneTodo(@RequestParam(name = "id") Integer todoId) {
        Todo updaTodo = todoService.findById(todoId);
        updaTodo.setDone(false);
        todoService.addTodo(updaTodo);
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("todo", todoService.findById(id));
        return "todos/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id,@Validated @ModelAttribute Todo todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "todos/edit";
        }
        todoService.addTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable Integer id) {
        todoService.deleteById(id);;
        return "redirect:/todos";
    }


    @PostMapping("/deleteAll")
    public String deleteAll() {
        todoService.deleteAllTodo();
        return "redirect:/todos";
    }

}