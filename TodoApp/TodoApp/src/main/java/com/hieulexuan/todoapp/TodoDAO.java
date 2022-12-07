package com.hieulexuan.todoapp;

import java.sql.SQLException;

public interface TodoDAO {
    void insertTodo(Todo todo) throws SQLException, ClassNotFoundException;
}
