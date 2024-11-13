package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @PostMapping("/average")
    public ResponseEntity<Map<String, Object>> getAverageMetrics(@RequestBody Employee e) {
        //error handling
        if(e.getEmployeeId() == null || e.getEmployeeName() == null || e.getPerformanceMetrics() == null || e.getPerformanceMetrics().getQualityOfWork() == null || e.getPerformanceMetrics().getCommunication() == null || e.getPerformanceMetrics().getTeamWork() == null || e.getPerformanceMetrics().getInitiative() == null) {
            return ResponseEntity.badRequest().build();
        }
        
        //calculate average score
        Float score = 0f;
        score = (e.getPerformanceMetrics().getQualityOfWork() + e.getPerformanceMetrics().getCommunication() + e.getPerformanceMetrics().getTeamWork() + e.getPerformanceMetrics().getInitiative()) / 4;

        //error handling
        if(score < 0 || score > 100) {
            return ResponseEntity.badRequest().build();
        }
        //define category
        String category = "";
        if(score >= 85) {
            category = "Exceeds Expectations";
        } else if (score >= 70 && score < 85) {
            category = "Meets Expectations";
        } else {
            category = "Needs Improvement";
        }

        Map<String, Object> result = new HashMap<>();

        result.put("employeeId", e.getEmployeeId());
        result.put("averageScore", score);
        result.put("category", category);

        return ResponseEntity.ok(result);
    }
}
