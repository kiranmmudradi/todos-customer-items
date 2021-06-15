package com.todos.service;

import com.todos.entity.TodoItems;
import com.todos.repository.TodoItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class TodoItemsService {
    @Autowired
    private TodoItemsRepository todoItemsRepository;

    public TodoItems saveTodoItem(TodoItems todoItems){
        //todoItems.setId(UUID.randomUUID().toString());
        todoItems.setIsActive("ACTIVE");
        todoItems.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        todoItems.setLastAccesses(new Timestamp(System.currentTimeMillis()));
        todoItemsRepository.save(todoItems);
        return todoItems;
    }

    public TodoItems deleteTodoItem(TodoItems todoItems){
        TodoItems existingItems = todoItemsRepository.findById(todoItems.getId()).orElse(null);
        existingItems.setIsActive("INACTIVE");
        existingItems.setLastAccesses(new Timestamp(System.currentTimeMillis()));
        todoItemsRepository.save(existingItems);
        return existingItems;
    }

    public TodoItems updateTodoItemText(TodoItems todoItems){
        TodoItems existingItems = todoItemsRepository.findById(todoItems.getId()).orElse(null);
        existingItems.setText(todoItems.getText());
        existingItems.setLastAccesses(new Timestamp(System.currentTimeMillis()));
        todoItemsRepository.save(existingItems);
        return existingItems;
    }

    public TodoItems updateTodoItemStatus(TodoItems todoItems){
        TodoItems existingItems = todoItemsRepository.findById(todoItems.getId()).orElse(null);
        existingItems.setStatus(todoItems.getStatus());
        existingItems.setLastAccesses(new Timestamp(System.currentTimeMillis()));
        todoItemsRepository.save(existingItems);
        return existingItems;
    }

    public TodoItems updateTodoItem(TodoItems todoItems){
        TodoItems existingItems = todoItemsRepository.findById(todoItems.getId()).orElse(null);
        existingItems.setCreatedBy(todoItems.getCreatedBy());
        existingItems.setAssignedTo(todoItems.getAssignedTo());
        existingItems.setText(todoItems.getText());
        existingItems.setStatus(todoItems.getStatus());
        existingItems.setDueOn(todoItems.getDueOn());
        existingItems.setIsActive(todoItems.getIsActive());
        existingItems.setLastAccesses(new Timestamp(System.currentTimeMillis()));
        todoItemsRepository.save(existingItems);
        return existingItems;
    }
}
