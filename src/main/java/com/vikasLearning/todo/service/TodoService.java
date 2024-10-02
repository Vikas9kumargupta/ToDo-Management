package com.vikasLearning.todo.service;

import com.vikasLearning.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto, Long id);

    void deleteTodo(Long id);

    void deleteAllTodo();

    TodoDto completeTodo(Long id);

    TodoDto inCompleteTodo(Long id);
}
