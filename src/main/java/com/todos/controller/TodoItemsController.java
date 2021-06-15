package com.todos.controller;

import com.todos.entity.TodoItems;
import com.todos.service.TodoItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoItemsController {
    @Autowired
    private TodoItemsService todoItemsService;
    @PostMapping("/addTodoItem")
    public TodoItems addTodoItem(@RequestBody TodoItems todoItems){
        return todoItemsService.saveTodoItem(todoItems);
    }
    @DeleteMapping("/deleteTodoItem/{id}")
    public TodoItems deleteTodoItem(@RequestBody TodoItems todoItems){
        return todoItemsService.deleteTodoItem(todoItems);
    }
    @PutMapping("/updateTodoItem/{id}")
    public TodoItems updateTodoItem(@RequestBody TodoItems todoItems){
        return todoItemsService.updateTodoItem(todoItems);
    }
    @PutMapping("/updateTodoItemStatus/{id}")
    public TodoItems updateTodoItemStatus(@RequestBody TodoItems todoItems){
        return todoItemsService.updateTodoItemStatus(todoItems);
    }
    @PutMapping("/updateTodoItemText/{id}")
    public TodoItems updateTodoItemText(@RequestBody TodoItems todoItems){
        return todoItemsService.updateTodoItemText(todoItems);
    }
}
