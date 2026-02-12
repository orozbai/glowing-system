package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("list")
public class EmployeeRepositorySaveToList implements EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private final EmployeeMapper employeeMapper;

    public EmployeeRepositorySaveToList(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }


    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {

        Employee employee = employeeMapper.mapToEmployee(employeeRequest);
        employee.setIdEmployee(UUID.randomUUID());

        employeeList.add(employee);

        return employeeMapper.mapToResponse(employee);
    }

    @Override
    public List<EmployeeResponse> findAllEmployees() {
        List<EmployeeResponse> responseList = new ArrayList<>();
        for (Employee employee : employeeList) {
            responseList.add(employeeMapper.mapToResponse(employee));
        }
        return responseList;
    }
}
