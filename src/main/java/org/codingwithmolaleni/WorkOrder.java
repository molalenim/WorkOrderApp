package org.codingwithmolaleni;

public class WorkOrder {
    private int Id;
    private String jobName;
    private int customerId;
    private String projectManager;
    private String goal;
    private String notes;

    // Constructor
    public WorkOrder(int Id, String jobName, int customerId, String projectManager, String goal, String notes) {
        this.Id = Id;
        this.jobName = jobName;
        this.customerId = customerId;
        this.projectManager = projectManager;
        this.goal = goal;
        this.notes = notes;
    }

    // Getters
    public String getJobName() {
        return jobName;
    }

    public int getCustomerId() {
        return Id;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public String getGoal() {
        return goal;
    }

    public String getNotes() {
        return notes;
    }

    public void setCustomerId(int customerId) {
        this.Id = customerId;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}