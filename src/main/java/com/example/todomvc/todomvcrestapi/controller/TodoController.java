package com.example.todomvc.todomvcrestapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.todomvc.todomvcrestapi.entity.Todo;
import com.example.todomvc.todomvcrestapi.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    @Operation(summary = "Get all todos")
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        LOGGER.info("Getting all todos");
        
        List<Todo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @Operation(summary = "Get todo by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(
            @Parameter(description = "ID of the todo",required= true)
            @PathVariable String id) {
        LOGGER.info("Getting todo by id: {}", id);
        
        Todo todo = todoService.getTodoById(id);
        
        if (todo != null) {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Create a new todo")
    @PostMapping
    public ResponseEntity<Todo> createTodo(
            @Parameter(description = "Todo object to be created",required= true)
            @RequestBody Todo todo) {
        LOGGER.info("Creating a new todo: {}", todo);
        
        Todo createdTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @Operation(summary = "Update todo by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(
            @Parameter(description = "ID of the todo to be updated", required= true)
            @PathVariable String id,
            @Parameter(description = "Updated todo object",required= true)
            @RequestBody Todo updatedTodo) {
        LOGGER.info("Updating todo with id {}: {}", id, updatedTodo);
        Todo todo = todoService.updateTodo(id, updatedTodo);
       
        if (todo != null) {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    @Operation(summary = "Delete todo by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTodo(
            @Parameter(description = "ID of the todo to be deleted",required= true)
            @PathVariable String id) {
    	LOGGER.info("Deleting todo with id: {}", id);
        
    	boolean isDeleted = todoService.deleteTodo(id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
}