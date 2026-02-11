package com.example.demo.repository;

import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Repository;

@Repository("db")
public class EmployeeRepositorySaveToDBMS implements EmployeeService {
    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        return null;
    }
}
