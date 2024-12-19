package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.service.ReportService;

import java.util.Map;

/**
 * REST controller to handle report-related operations.
 * Provides endpoints to retrieve various reports for admin users.
 */
@RestController
@RequestMapping("/crm.technothinksup.in/admin/reports")
public class ReportController {

    @Autowired
    private ReportService reportService; // Service to handle business logic for reports

    /**
     * Retrieve a task summary report.
     *
     * @return A map containing the task summary data.
     *         The structure of the map depends on the implementation in ReportService.
     */
    @GetMapping("/summary")
    public Map<String, Object> getTaskSummaryReport() {
        // Delegate the task of generating the report to the reportService
        return reportService.getTaskSummary();
    }
}
