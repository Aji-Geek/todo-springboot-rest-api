package com.example.todomvc.todomvcrestapi.service;

import java.util.List;

import com.example.todomvc.todomvcrestapi.entity.Todo;

public interface TodoService {
	List<Todo> getAllTodos();

	Todo getTodoById(String id);

	Todo createTodo(Todo todo);

	Todo updateTodo(String id, Todo todo);

	boolean deleteTodo(String id);
}
