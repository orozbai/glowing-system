package com.example.demo.repository;

import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service("list")
public class EmployeeRepositorySaveToList implements EmployeeService {
    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        return null;
    }
}
