package kg.nurtelecom.internlabs.employeeservice.repository;

import kg.nurtelecom.internlabs.employeeservice.entity.Employee;
import kg.nurtelecom.internlabs.employeeservice.mapper.EmployeeMapper;
import kg.nurtelecom.internlabs.employeeservice.payload.request.EmployeeRequest;
import kg.nurtelecom.internlabs.employeeservice.payload.response.EmployeeResponse;
import kg.nurtelecom.internlabs.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("list")
public class EmployeeRepositorySaveToList implements EmployeeService {

    private final List<Employee> employeeList;
    private final EmployeeMapper employeeMapper;

    public EmployeeRepositorySaveToList(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
        this.employeeList = new ArrayList<>();
    }


    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {

        for (Employee employee : employeeList) {
            if (employee.getEmailEmployee().equals(employeeRequest.email())) {
                throw new RuntimeException("Employee with email " + employeeRequest.email() + " already exists");
            }
        }

        for (Employee employee : employeeList) {
            if (employee.getPhoneNumberEmployee().equals(employeeRequest.phoneNumber())) {
                throw new RuntimeException("Employee with phone number " + employeeRequest.phoneNumber() + " already exists");
            }
        }

        Employee employee = employeeMapper.mapToEmployee(employeeRequest);
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
