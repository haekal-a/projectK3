package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Todo {

    private BigDecimal id;
    private String username;
    private String description;
    private Boolean isDone;
    private Date targetDate;

    // default constructor
    protected Todo() {

    }

    public Todo(BigDecimal id, String userName, String description, Date targetDate) {
        this.id = id;
        this.username = userName;
        this.description = description;
        this.isDone = false;
        this.targetDate = targetDate;
    }

    @Id
    @GeneratedValue
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;

        Todo todo = (Todo) o;

        if (id != null ? !id.equals(todo.id) : todo.id != null) return false;
        if (username != null ? !username.equals(todo.username) : todo.username != null) return false;
        if (description != null ? !description.equals(todo.description) : todo.description != null) return false;
        if (isDone != null ? !isDone.equals(todo.isDone) : todo.isDone != null) return false;
        return targetDate != null ? targetDate.equals(todo.targetDate) : todo.targetDate == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
