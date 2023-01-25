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
   

    //一覧ページ表示
    @GetMapping("/todos")
    public String index(@ModelAttribute Todo todo, Model model) {
        model.addAttribute("allTodo", todoService.searchAll());
        return "todos/index";
    }


    //詳細ページに移動
    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("todo", todoService.findById(id));
        return "todos/show";
    }

    //項目、メモ、日付作成
    @PostMapping("/create")
    public String createTodo(@Validated @ModelAttribute Todo todo, BindingResult bindingResult,Model model ) {

        if(bindingResult.hasErrors()){
            model.addAttribute("allTodo", todoService.searchAll());
            return "todos/index";
        }
        todoService.addTodo(todo);
        return "redirect:/todos";
    }

     //未完了Listのボタンを押したら完了Listに項目が移動
    @PostMapping("/done")
    public String doneTodo(@RequestParam(name = "id") Integer todoId) {
        Todo updaTodo = todoService.findById(todoId);
        updaTodo.setDone(true);
        todoService.addTodo(updaTodo);
        return "redirect:/todos";
    }

    //完了Listのボタンを押したら未完了Listに項目が移動
    @PostMapping("/notdone")
    public String notdoneTodo(@RequestParam(name = "id") Integer todoId) {
        Todo updaTodo = todoService.findById(todoId);
        updaTodo.setDone(false);
        todoService.addTodo(updaTodo);
        return "redirect:/todos";
    }

    //各投稿の編集ページに遷移
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("todo", todoService.findById(id));
        return "todos/edit";
    }

    //選択したものを更新
    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id,@Validated @ModelAttribute Todo todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "todos/edit";
        }
        todoService.addTodo(todo);
        return "redirect:/todos";
    }

    //選択したものを消す
    @PostMapping("/delete/{id}")
    public String remove(@PathVariable Integer id) {
        todoService.deleteById(id);;
        return "redirect:/todos";
    }

    //完了済みのものを全て消す
    @PostMapping("/deleteAll")
    public String deleteAll() {
        todoService.deleteAllTodo();
        return "redirect:/todos";
    }
    

}