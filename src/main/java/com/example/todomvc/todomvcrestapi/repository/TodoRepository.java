package com.example.todomvc.todomvcrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todomvc.todomvcrestapi.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, String> {
}
