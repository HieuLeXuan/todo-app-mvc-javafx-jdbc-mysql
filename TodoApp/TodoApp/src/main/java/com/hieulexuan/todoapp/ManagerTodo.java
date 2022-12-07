package com.hieulexuan.todoapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerTodo implements TodoDAO {
    @Override
    public void insertTodo(Todo todo) throws SQLException, ClassNotFoundException {
        java.sql.Connection con = JDBCConnection.getConnection();
        String sql = "insert into todo(name, description, date) values (?, ?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, todo.getName());
        preparedStatement.setString(2, todo.getDescription());
        preparedStatement.setTimestamp(3, todo.getDate());

        preparedStatement.executeUpdate();

        con.close();
    }
}
