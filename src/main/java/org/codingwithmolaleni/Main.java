package org.codingwithmolaleni;


public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the Work Order Application...");

        // Test the database connection
        if (DatabaseConnector.connect() != null) {
            System.out.println("Database connection successful!");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}