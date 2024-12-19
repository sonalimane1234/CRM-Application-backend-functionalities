package com.crm.controller;

import com.crm.entities.Task;
import com.crm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing tasks. Provides CRUD operations for tasks in the
 * application.
 */
@RestController
@RequestMapping("/crm.technothinksup.in/admin/task")
public class TaskController {

	@Autowired
	private TaskService taskService; // Service layer for handling task-related business logic

	/**
	 * Retrieve all tasks.
	 *
	 * @return A list of all tasks.
	 */
	@GetMapping
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	/**
	 * Create a new task.
	 *
	 * @param task The task object to be created.
	 * @return The newly created task.
	 */
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}

	/**
	 * Update an existing task by its ID.
	 *
	 * @param id          The ID of the task to be updated.
	 * @param taskDetails The task object containing the updated details.
	 * @return The updated task object.
	 */
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
		return taskService.updateTask(id, taskDetails);
	}

	/**
	 * Delete a task by its ID.
	 *
	 * @param id The ID of the task to be deleted.
	 */
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}

	/**
	 * Retrieve a specific task by its ID.
	 *
	 * @param id The ID of the task to be retrieved.
	 * @return The task object if found, or an error message if not found.
	 */
	// Uncomment and use this method if needed
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
//        Task task = taskService.getTaskById(id);
//
//        // Check if the task exists
//        if (task != null) {
//            return ResponseEntity.ok(task); // Return the task with HTTP status 200 (OK)
//        } else {
//            // Return an error message with HTTP status 404 (Not Found)
//            return ResponseEntity.status(404).body("Task Not Found With ID " + id + ". Kindly Check the ID.");
//        }
//    }
}
