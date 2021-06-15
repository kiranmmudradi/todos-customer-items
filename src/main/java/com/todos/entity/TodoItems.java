package com.todos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TODOS_ITEMS_TBL")
public class TodoItems {
    @Id
    private String id;
    private String createdBy;
    private String assignedTo;
    private String text;
    private String isActive;
    private String status;
    private Timestamp dueOn;
    private Timestamp lastAccesses;
    private Timestamp createdAt;
}
