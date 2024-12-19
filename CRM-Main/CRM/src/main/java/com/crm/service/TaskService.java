package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entities.Task;
import com.crm.repository.TaskRepository;

/**
 * Service class for managing tasks.
 * Handles operations such as retrieving, creating, updating, and deleting tasks.
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository; // Repository for task data access and persistence

    /**
     * Retrieve all tasks from the database.
     *
     * @return A list of all tasks.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Create a new task and save it to the database.
     *
     * @param task The task to be created.
     * @return The saved task entity.
     */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Update an existing task based on the provided task ID and details.
     *
     * @param taskId      The ID of the task to update.
     * @param taskDetails The new details of the task.
     * @return The updated task entity, or null if the task was not found.
     */
    public Task updateTask(Long taskId, Task taskDetails) {
        // Find the task by ID; return null if not found
        Task task = taskRepository.findById(taskId).orElse(null);

        if (task != null) {
            // Update task fields with new details
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setDeadline(taskDetails.getDeadline());
            task.setPriority(taskDetails.getPriority());
            task.setStatus(taskDetails.getStatus());
            return taskRepository.save(task); // Save the updated task to the database
        }
        return null; // Return null if the task with the specified ID was not found
    }

    /**
     * Delete a task from the database by its ID.
     *
     * @param taskId The ID of the task to delete.
     */
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    /**
     * Retrieve a specific task by its ID.
     *
     * @param taskId The ID of the task to retrieve.
     * @return The task entity, or null if not found.
     */
    public Task getTaskById(Long taskId) {
        return taskRepository.getById(taskId);
    }
}
