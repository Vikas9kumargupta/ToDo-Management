package com.vikasLearning.todo.controller;


import com.vikasLearning.todo.dto.TodoDto;
import com.vikasLearning.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;
    //Build Add Todo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    //Build getTodo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    //Build getAllTodo REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
         List<TodoDto> todos = todoService.getAllTodos();
         //return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

    //Build updateTodo REST API.
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    //Build Todo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo Deleted Successfully!.");
    }

    //Delete All Todos REST API
    @org.jetbrains.annotations.NotNull
    @DeleteMapping
    private ResponseEntity<String> deleteAllTodos(){
        todoService.deleteAllTodo();
        return ResponseEntity.ok("All Todos Deleted Successfully !.");
    }

    //Build Complete Todo REST API
    @PatchMapping("{id}/complete")//it is used to update the resource partially
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.completeTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    //Build InComplete Todo REST API
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }

}
