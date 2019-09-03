package com.example.demo.controller;

import com.example.demo.domain.Todo;
import com.example.demo.repo.TodoRepository;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJpaController {

    private TodoService todoService;
    private TodoRepository todoRepository;

    @Autowired
    public TodoJpaController(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @GetMapping(value = "/jpa/user/{userName}/todos")
    public List<Todo> getAllTodos(@PathVariable String userName) {
        return todoRepository.getTodosByUsername(userName);
//        return todoService.getAllTodo(userName);
    }

    @GetMapping(value = "/jpa/user/{userName}/todos/{id}")
    public Todo getTodo(@PathVariable String userName, @PathVariable String id) {
        return todoRepository.findById(new BigDecimal(id)).get();
//        return todoService.getTodoById(new BigDecimal(id));
    }

    @DeleteMapping(value = "/jpa/user/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable String id) {
//        Todo todo = todoService.deleteTodo(new BigDecimal(id));
        todoRepository.deleteById(new BigDecimal(id));
       /* if (todo != null) { // berhasil hapus
            //standard return for delete success
            return ResponseEntity.noContent().build();
        }*/
        //standard return for delete failed
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/jpa/user/{userName}/todos")
    public ResponseEntity<Todo> updateTodo(@PathVariable String userName, @RequestBody Todo todo) {
//        Todo todoUpdated = todoService.saveTodo(todo);
        Todo updatedTodo = todoRepository.save(todo);
        //standard return for update success
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping(value = "/jpa/user/{userName}/todos")
    public ResponseEntity<Void> saveTodo(@PathVariable String userName, @RequestBody Todo todo) {
//        Todo createdUpdated = todoService.saveTodo(todo);
        todo.setUsername(userName);
        Todo createdTodo = todoRepository.save(todo);

        // standard return for post success, adalah alamat URI hasil save data tersebut
        // ini adalah salah satu cara membuat URI
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
