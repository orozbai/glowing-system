package com.example.demo.service;

import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    EmployeeResponse save(EmployeeRequest employeeRequest);
    List<EmployeeResponse> findAllEmployees();
}
