package com.example.g139springfirst.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DbManager {

    @Bean
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "postgres"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error in connection: " + e.getMessage(), e);
        }
    }
}
