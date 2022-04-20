package com.ista.isp.assessment.todo.services;

import com.ista.isp.assessment.todo.model.TodoModel;
import com.ista.isp.assessment.todo.model.TodoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoService{
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoModel> getTodoList() {
        return (List<TodoModel>) todoRepository.findAll();
    }

    public TodoModel getTodo(int id) {
        Optional<TodoModel> todo = todoRepository.findById(id);
        return todo.orElse(null);
    }

    public TodoModel storeTodo(TodoModel todo) {
        return todoRepository.save(todo);
    }

    public boolean deleteTodo(int id) {
        boolean deleted = false;
        Optional<TodoModel> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
            deleted = true;
        }
        return deleted;
    }
}