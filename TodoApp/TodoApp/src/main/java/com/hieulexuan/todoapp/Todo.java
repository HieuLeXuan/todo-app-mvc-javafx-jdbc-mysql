package com.hieulexuan.todoapp;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Todo {

    private String name;
    private String description;
    private Timestamp date;

    public Todo() {
    }

    public Todo(String name, String description, Timestamp date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TodoApp{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", date=" + date + '}';
    }
}
