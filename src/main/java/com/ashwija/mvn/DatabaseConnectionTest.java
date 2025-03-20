package com.ashwija.mvn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void test(String URL, String USER, String PASSWORD) {
        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // If successful, print success message
            if (connection != null) {
                System.out.println("Successfully connected to MySQL database!");
                connection.close(); // Close the connection
            }
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}