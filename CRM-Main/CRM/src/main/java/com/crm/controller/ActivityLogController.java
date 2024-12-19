package com.crm.controller;

import com.crm.entities.ActivityLog;
import com.crm.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller to manage activity logs.
 * Provides endpoints to retrieve, add, and get details of activity logs.
 */
@RestController
@RequestMapping("/crm.technothinksup.in/admin/activity-logs") // these is for to hit url from postman 
public class ActivityLogController {

	@Autowired
	private ActivityLogService activityLogService;

	@GetMapping
	public List<ActivityLog> getAllLogs() {
		return activityLogService.getLogs();
	}

	@PostMapping
	public ActivityLog logAction(@RequestBody ActivityLog log) {
		return activityLogService.logAction(log);
	}
	/**
     * Retrieve a specific activity log by its ID.
     *
     * @param id the ID of the activity log to be retrieved.
     * @return the activity log entry if found, or an error message if not found.
     */
	@GetMapping("/{id}")
	public ResponseEntity<?> getActivityLogById(@PathVariable Long id) {
		ActivityLog activityLog = activityLogService.getActivityLogById(id);

		if (activityLog != null) {
			return ResponseEntity.ok(activityLog);
		} else { 
			return ResponseEntity.status(404).body("Activity Log with ID " + id + " not found.");
		}
	}

}
