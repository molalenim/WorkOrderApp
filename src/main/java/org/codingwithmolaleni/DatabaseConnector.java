package org.codingwithmolaleni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/WorkOrderDB";
    private static final String USER = "WorkOrderDB"; // Replace later with your MySQL username
    private static final String PASSWORD = "WorkOrderDB"; // Replace later with your MySQL password

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}