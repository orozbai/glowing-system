package kg.nurtelecom.internlabs.employeeservice.service;

import kg.nurtelecom.internlabs.employeeservice.payload.request.EmployeeRequest;
import kg.nurtelecom.internlabs.employeeservice.payload.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse save(EmployeeRequest employeeRequest);
    List<EmployeeResponse> findAllEmployees();
}
