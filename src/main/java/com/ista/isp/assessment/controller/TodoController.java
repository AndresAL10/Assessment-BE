package com.ista.isp.assessment.todo.controller;

import com.ista.isp.assessment.todo.model.TodoModel;
import com.ista.isp.assessment.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public List<TodoModel> getTodoList() {
        return todoService.getTodoList();
    }

    @GetMapping("/{id}")
    public TodoModel getTodo(@PathVariable("id") int id) {
        TodoModel todo = todoService.getTodo(id);
    }

    @PostMapping()
    public ResponseEntity<String> storeTodo(@RequestBody TodoModel todo) {
    }

    @PutMapping("/{id}")
    public TodoModel storeTodo(@PathVariable("id") int id, @RequestBody TodoModel todo) {
        TodoModel exTodo = todoService.getTodo(id);
        todo.setId(id);
    }
}