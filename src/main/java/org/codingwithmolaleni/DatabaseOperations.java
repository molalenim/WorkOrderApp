package org.codingwithmolaleni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations {
    // Add a work order to the database
    public void addWorkOrder(WorkOrder workOrder) {
        String sql = "INSERT INTO WorkOrders (job_name, customer_id, project_manager, goal, notes) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, workOrder.getJobName());
            pstmt.setInt(2, workOrder.getCustomerId());
            pstmt.setString(3, workOrder.getProjectManager());
            pstmt.setString(4, workOrder.getGoal());
            pstmt.setString(5, workOrder.getNotes());

            pstmt.executeUpdate();
            System.out.println("Work order added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding work order: " + e.getMessage());
        }
    }

    // Update a work order on the database
    public boolean updateWorkOrder(int workOrderId, String jobName, int customerId, String projectManager, String goal, String notes) {
        String query = "UPDATE WorkOrders SET job_name = ?, customer_id = ?, project_manager = ?, goal = ?, notes = ? WHERE id = ?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, jobName);
            preparedStatement.setInt(2, customerId);
            preparedStatement.setString(3, projectManager);
            preparedStatement.setString(4, goal);
            preparedStatement.setString(5, notes);
            preparedStatement.setInt(6, workOrderId);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Failed to update work order: " + e.getMessage());
            return false;
        }
    }

    // Delete a work order from the database
    public boolean deleteWorkOrder(int workOrderId) {
        String query = "DELETE FROM WorkOrders WHERE id = ?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, workOrderId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Failed to delete work order: " + e.getMessage());
            return false;
        }
    }

    // retrieve work order from the database
    public List<WorkOrder> getWorkOrders(Integer workOrderId) {
        String query = workOrderId == null ? "SELECT * FROM WorkOrders" : "SELECT * FROM WorkOrders WHERE id = ?";
        List<WorkOrder> workOrders = new ArrayList<>();
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (workOrderId != null) {
                preparedStatement.setInt(1, workOrderId);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WorkOrder workOrder = new WorkOrder(
                        resultSet.getInt("id"),              // Matches `int id`
                        resultSet.getString("job_name"),    // Matches `String jobName`
                        resultSet.getInt("customer_id"),    // Matches `int customerId`
                        resultSet.getString("project_manager"), // Matches `String projectManager`
                        resultSet.getString("goal"),        // Matches `String goal`
                        resultSet.getString("notes")        // Matches `String notes`
                );
                workOrders.add(workOrder);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve work orders: " + e.getMessage());
        }
        return workOrders;
    }

}
