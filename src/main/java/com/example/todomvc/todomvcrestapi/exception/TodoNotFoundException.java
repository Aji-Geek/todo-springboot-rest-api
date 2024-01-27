package com.example.todomvc.todomvcrestapi.exception;

public class TodoNotFoundException extends RuntimeException{
	
	public TodoNotFoundException(String message) {
		super(message);
	}

}
