package com.naoto.portfolio.infrastructure.todos;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.naoto.portfolio.domain.todos.model.Todo;

@Mapper
public interface TodoMapper {
    public List<Todo> selectAll();
    public void add(Todo todo);
}
