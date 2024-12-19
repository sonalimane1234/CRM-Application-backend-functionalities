package com.crm.service;

import com.crm.entities.ActivityLog;
import com.crm.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogService {

	@Autowired
	private ActivityLogRepository activityLogRepository;

	public List<ActivityLog> getLogs() {
		return activityLogRepository.findAll();
	}

	public ActivityLog logAction(ActivityLog log) {
		return activityLogRepository.save(log);
	}

	public ActivityLog getActivityLogById(Long id) {
		return activityLogRepository.findById(id).orElse(null); 
		
		
	}
}
