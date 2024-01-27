package com.example.todomvc.todomvcrestapi.exception;

public class TodoValidationException extends RuntimeException{
	
	public TodoValidationException(String message) {
		super(message);
	}

}
