package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("db")
public class EmployeeRepositorySaveToDBMS implements EmployeeService {

    private final EmployeeJpaRepository employeeJpaRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeRepositorySaveToDBMS(EmployeeJpaRepository employeeJpaRepository,
                                        EmployeeMapper employeeMapper) {
        this.employeeJpaRepository = employeeJpaRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {

        try {
                    if (employeeJpaRepository.existsByEmailEmployee(employeeRequest.email())) {
            throw new RuntimeException("Employee with email " + employeeRequest.email() + " already exists");
        }

        if (employeeRequest.phoneNumber() != null &&
                employeeJpaRepository.existsByPhoneNumberEmployee(employeeRequest.phoneNumber())) {
            throw new RuntimeException("Employee with phone number " + employeeRequest.phoneNumber() + " already exists");
        }

            Employee employee = employeeMapper.mapToEmployee(employeeRequest);
            employeeJpaRepository.save(employee);

            return employeeMapper.mapToResponse(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<EmployeeResponse> findAllEmployees() {
        return List.of();
    }
}
