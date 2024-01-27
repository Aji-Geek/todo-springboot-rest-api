package com.example.todomvc.todomvcrestapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todomvc.todomvcrestapi.entity.Todo;
import com.example.todomvc.todomvcrestapi.exception.TodoNotFoundException;
import com.example.todomvc.todomvcrestapi.exception.TodoValidationException;
import com.example.todomvc.todomvcrestapi.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TodoServiceImpl.class);

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<Todo> getAllTodos() {
		LOGGER.info("Getting all todos");
		return todoRepository.findAll();
	}

	@Override
	public Todo getTodoById(String id) {
		LOGGER.info("Getting todo by id: {}", id);

		Objects.requireNonNull(id, "Todo ID must not be null");
		return todoRepository.findById(id)
				.orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));

	}

	@Override
	public Todo createTodo(Todo todo) {
		LOGGER.info("Creating a new todo: {}", todo);
		validateTodoFields(todo);
		return todoRepository.save(todo);
	}

	@Override
	public Todo updateTodo(String id, Todo updatedTodo) {
		LOGGER.info("Updating todo with id {}: {}", id, updatedTodo);
		Objects.requireNonNull(id, "Todo ID must not be null");
        validateTodoFields(updatedTodo);
        
		Todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
		todo.setTitle(updatedTodo.getTitle());
		todo.setCompleted(updatedTodo.isCompleted());
		return todoRepository.save(todo);
	}

	@Override
	public boolean deleteTodo(String id) {
		LOGGER.info("Deleting todo with id: {}", id);
		Objects.requireNonNull(id, "Todo ID must not be null");
		Optional<Todo> optionalTodo = todoRepository.findById(id);

		if (optionalTodo.isPresent()) {
			todoRepository.deleteById(id);
			LOGGER.info("Todo with id {} deleted successfully", id);
			return true;
		} else {
			LOGGER.warn("Todo with id {} not found. Deletion failed.", id);
			return false;
		}
	}

	private void validateTodoFields(Todo todo) {
		Objects.requireNonNull(todo, "Todo must not be null");

		String title = Objects.requireNonNullElse(todo.getTitle(), "");
		Boolean completed = Objects.requireNonNullElse(todo.isCompleted(), false);

		if (title.isEmpty() || completed == null) {
			throw new TodoValidationException("Todo title and completed status must not be null");
		}
	}
}
