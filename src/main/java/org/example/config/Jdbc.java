package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }


}
