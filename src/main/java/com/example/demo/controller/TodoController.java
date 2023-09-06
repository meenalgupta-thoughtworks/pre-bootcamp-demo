package com.example.demo.controller;

import lombok.NonNull;
import com.example.demo.model.TodoItem;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.TodoRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoRepository repository;

    @GetMapping
    public List<TodoItem> findAllTodos() {
        return repository.findAll();
    }

    @PostMapping
    public TodoItem saveTodo(@Validated @NotNull @RequestBody TodoItem todoItem) {
        return repository.save(todoItem);
    }

    @PutMapping
    public TodoItem updateTodo(@Validated @NonNull @RequestBody TodoItem todoItem) {
        return repository.save(todoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
