package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("list")
public class EmployeeRepositorySaveToList implements EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private final EmployeeMapper employeeMapper;

    public EmployeeRepositorySaveToList(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }


    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        return null;
    }

    @Override
    public List<EmployeeResponse> findAllEmployees() {
        return List.of();
    }
}
