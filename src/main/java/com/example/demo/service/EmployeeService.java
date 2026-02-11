package com.example.demo.service;

import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;

import java.io.IOException;

public interface EmployeeService {
    EmployeeResponse save(EmployeeRequest employeeRequest) throws IOException;
}
