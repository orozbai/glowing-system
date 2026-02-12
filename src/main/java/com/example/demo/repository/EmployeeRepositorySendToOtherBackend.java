package com.example.demo.repository;

import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("remote")
public class EmployeeRepositorySendToOtherBackend implements EmployeeService {
    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        return null;
    }

    @Override
    public List<EmployeeResponse> findAllEmployees() {
        return List.of();
    }
}
