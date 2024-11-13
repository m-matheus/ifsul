package com.example.demo.domain;

import lombok.Data;


@Data
public class Employee {
    private String employeeId;
    private String employeeName;
    private Metrics performanceMetrics;
}
