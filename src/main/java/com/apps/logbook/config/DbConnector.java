/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apps.logbook.config;

/**
 *
 * @author lenovo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DbConnector {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/";
    private static final String JDBC_USER = "postgres"; //username
    private static final String JDBC_PASSWORD = "P@ssword123"; // the password of the Postgres
    private static final String DEFAULT_DB = "postgres"; // Default database to connect to
    private static final String NEW_DATABASE_NAME = "logbook"; // New database name
    private static final String NEW_DATABASE_URL = JDBC_URL + NEW_DATABASE_NAME;
    
    public DbConnector() {
        try {
            createDatabaseIfNotExists();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createDatabaseIfNotExists() throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DEFAULT_DB, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {

            String createDatabaseSQL = "CREATE DATABASE " + NEW_DATABASE_NAME;
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Database " + NEW_DATABASE_NAME + " created successfully.");

        } catch (SQLException e) {
            if ("42P04".equals(e.getSQLState())) {
                System.out.println("Database " + NEW_DATABASE_NAME + " already exists.");
            } else {
                throw e;
            }
        }
    }

    public void createStudentTableIfNotExists() {
        String sql = """
            CREATE TABLE IF NOT EXISTS students (
                id SERIAL PRIMARY KEY,
                studentID VARCHAR(25) UNIQUE NOT NULL,
                fname VARCHAR(100),
                mname VARCHAR(100),
                lname VARCHAR(100),
                program VARCHAR(100)
                
            )
        """;

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement()
        ) {
            stmt.executeUpdate(sql);
            System.out.println("Students table created or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating students table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(NEW_DATABASE_URL, JDBC_USER, JDBC_PASSWORD);
    }
}