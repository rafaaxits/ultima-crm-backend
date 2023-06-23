package com.ultimaschool.java.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private Connection connection;

    public static DatabaseConnection getInstance() {
        if(instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {
        try {
            this.createConnection();
        } catch (SQLException e) {
            System.out.println("SQL Exception error: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void createConnection() throws SQLException {
        this.connection = DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/crm_db",
                        "root",
                        "aloha1997");
        this.connection.setAutoCommit(true);
    }

    public void closeConnection () {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception error: " + e.getMessage());
        }

    }
}
