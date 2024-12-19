package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.repository.TaskRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for generating task-related reports.
 * Provides a method to retrieve a summary of tasks including total, completed, and pending tasks.
 */
@Service
public class ReportService {

    @Autowired
    private TaskRepository taskRepository; // Repository for accessing task-related data from the database

    /**
     * Generate a task summary report.
     *
     * @return A map containing the task summary with the following keys:
     *         - "Total Tasks": Total number of tasks in the system.
     *         - "Completed Tasks": Number of tasks with a "Completed" status.
     *         - "Pending Tasks": Number of tasks with a "Pending" status.
     */
    public Map<String, Object> getTaskSummary() {
        // Count the number of tasks with "Completed" status
        long completedTasks = taskRepository.countByStatus("Completed");

        // Count the number of tasks with "Pending" status
        long pendingTasks = taskRepository.countByStatus("Pending");

        // Count the total number of tasks
        long totalTasks = taskRepository.count();

        // Create a report map to store the task summary
        Map<String, Object> report = new HashMap<>();
        report.put("Total Tasks", totalTasks);         // Add total tasks to the report
        report.put("Completed Tasks", completedTasks); // Add completed tasks to the report
        report.put("Pending Tasks", pendingTasks);     // Add pending tasks to the report

        return report; // Return the task summary report
    }
}
