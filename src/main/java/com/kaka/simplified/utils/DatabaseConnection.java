package com.kaka.simplified.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost/your_database_name";
    private static final String USER = "your_user_name";
    private static final String PS = "your_password";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PS);
    }
}
