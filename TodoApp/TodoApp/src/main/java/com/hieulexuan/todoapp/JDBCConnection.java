package com.hieulexuan.todoapp;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    public static java.sql.Connection getConnection() {
        String DATABASE_URL = "jdbc:mysql://localhost:3306/todo_app_javafx?useSSL=false";
        String DATABASE_USERNAME = "root";
        String DATABASE_PASSWORD = "Nguyenle+-0!@#$";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
