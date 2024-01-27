package com.example.todomvc.todomvcrestapi.service;

import com.example.todomvc.todomvcrestapi.entity.Todo;
import com.example.todomvc.todomvcrestapi.exception.TodoValidationException;
import com.example.todomvc.todomvcrestapi.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TodoServiceTest {

    @Mock
    private TodoRepository todosRepository;

    @InjectMocks
    private TodoService todoService = new TodoServiceImpl();
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TodoServiceTest.class);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTodos() {
    	LOGGER.info("Getting all todos Test Case");
        List<Todo> mockTodos = new ArrayList<>();
        when(todosRepository.findAll()).thenReturn(mockTodos);

       
        List<Todo> result = todoService.getAllTodos();

        verify(todosRepository, times(1)).findAll();

        assertEquals(mockTodos, result);
    }

    @Test
    public void testGetTodoById() {
    	LOGGER.info("Get Todo by Id Test Case");
        String todoId = "1";
        Todo mockTodo = new Todo();
        when(todosRepository.findById(todoId)).thenReturn(Optional.of(mockTodo));

        Todo result = todoService.getTodoById(todoId);

        verify(todosRepository, times(1)).findById(todoId);

        assertEquals(mockTodo, result);
    }

    @Test
    public void testCreateTodo() {
    	LOGGER.info("Create Todo Test Case");
        Todo todoToCreate = new Todo();
        todoToCreate.setTitle("Task 1");
        todoToCreate.setCompleted(false);
        when(todosRepository.save(todoToCreate)).thenReturn(todoToCreate);

        Todo result = todoService.createTodo(todoToCreate);

        verify(todosRepository, times(1)).save(todoToCreate);

        assertEquals(todoToCreate, result);
    }
    
    @Test
    public void testCreateTodoWithNullFields() {
    	LOGGER.info("Create Todo with Null Test Case");
        Todo todoWithNullTitle = new Todo();
        todoWithNullTitle.setCompleted(true);
        when(todosRepository.save(any(Todo.class))).thenReturn(null);

        TodoValidationException exception = assertThrows(TodoValidationException.class, () -> {
            todoService.createTodo(todoWithNullTitle);
        });

        assertEquals("Todo title and completed status must not be null", exception.getMessage());
    }

    @Test
    public void testUpdateTodo() {
    	LOGGER.info("Update Todo  Test Case");
    	Todo updatedTodo = new Todo();
	    updatedTodo.setId("2");
	    updatedTodo.setTitle("Task 2 updated");
	    updatedTodo.setCompleted(true);

	    when(todosRepository.findById("2")).thenReturn(Optional.of(updatedTodo));
	    when(todosRepository.save(updatedTodo)).thenReturn(updatedTodo);

	    Todo result = todoService.updateTodo("2", updatedTodo);

	    verify(todosRepository, times(1)).save(updatedTodo);
	    assertNotNull(result);
    }
    
    @Test
    public void testDeleteTodo() {
    	LOGGER.info("Delete Todo by Id Test Case");
        when(todosRepository.findById("1")).thenReturn(Optional.of(new Todo()));

        todoService.deleteTodo("1");

        verify(todosRepository).deleteById("1");
    }

}
