package org.codingwithmolaleni;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the Work Order Application...");

        // Test the database connection
        if (DatabaseConnector.connect() != null) {
            System.out.println("Database connection successful!");
        } else {
            System.out.println("Failed to connect to the database.");
        }

        // Create a new work order
        WorkOrder newWorkOrder = new WorkOrder(1,"Smith",  1,"LA", "5 days", "Example notes");

        //Add the work oder to the database
        DatabaseOperations dbOps = new DatabaseOperations();
        dbOps.addWorkOrder(newWorkOrder);

        // Update work order
        DatabaseOperations operations = new DatabaseOperations();
        boolean isUpdated = operations.updateWorkOrder(1, "Updated Job", 2, "Updated Manager", "2 days", "Updated notes");
        System.out.println("Update successful: " + isUpdated);

        // Delete work order
        boolean isDeleted = operations.deleteWorkOrder(1);
        System.out.println("Delete successful: " + isDeleted);

        //retrieve all work orders
        List<WorkOrder> workOrders = operations.getWorkOrders(null); // Retrieve all work orders
        for (WorkOrder workOrder : workOrders) {
            System.out.println(workOrder);
        }



    }


}