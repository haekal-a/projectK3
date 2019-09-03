package com.example.demo.service;

import com.example.demo.domain.Todo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class TodoService {

    private static List<Todo> dummyTodos = new ArrayList<>();
    private static int idCounter;

    static {
        dummyTodos.add(new Todo(new BigDecimal(++idCounter), "Lepi", "Coding", new Date()));
        dummyTodos.add(new Todo(new BigDecimal(++idCounter), "Lepi", "Fishing", new Date()));
        dummyTodos.add(new Todo(new BigDecimal(++idCounter), "Lepi", "Dating", new Date()));
        dummyTodos.add(new Todo(new BigDecimal(++idCounter), "Lepi", "Badminton", new Date()));
    }

    public List<Todo> getAllTodo(String userName) {
        return dummyTodos;
    }

    public Todo saveTodo (Todo todo){
        if(todo.getId().longValue() == -1 || todo.getId().longValue() == 0){ // simpan pertama
            todo.setId(new BigDecimal(++idCounter));
            dummyTodos.add(todo);

        } else { // update todo
            deleteTodo(todo.getId());
            dummyTodos.add(todo);
        }

        return todo;
    }

    public Todo deleteTodo(BigDecimal id){
        Todo todo = getTodoById(id);
        if (todo != null){
            dummyTodos.remove(todo);
        }

        return todo;
    }

    public Todo getTodoById (BigDecimal id){
        for(Todo todo : dummyTodos){
            if(Objects.equals(todo.getId(), id)){
                return todo;
            }
        }

        return null;
    }

}
