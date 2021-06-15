package com.todos.repository;

import com.todos.entity.TodoItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemsRepository extends JpaRepository<TodoItems,String> {
}
