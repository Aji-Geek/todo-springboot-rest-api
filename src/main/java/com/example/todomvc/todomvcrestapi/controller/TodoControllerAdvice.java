package com.example.todomvc.todomvcrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.todomvc.todomvcrestapi.exception.TodoNotFoundException;
import com.example.todomvc.todomvcrestapi.exception.TodoValidationException;

@RestControllerAdvice
public class TodoControllerAdvice {
	
	@ExceptionHandler(TodoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleTodoNotFoundException(TodoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(TodoValidationException.class)
    public ResponseEntity<String> handleTodoValidationException(TodoValidationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
