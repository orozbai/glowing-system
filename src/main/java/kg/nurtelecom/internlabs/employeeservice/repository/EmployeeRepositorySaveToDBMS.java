package kg.nurtelecom.internlabs.employeeservice.repository;

import kg.nurtelecom.internlabs.employeeservice.entity.Employee;
import kg.nurtelecom.internlabs.employeeservice.mapper.EmployeeMapper;
import kg.nurtelecom.internlabs.employeeservice.payload.request.EmployeeRequest;
import kg.nurtelecom.internlabs.employeeservice.payload.response.EmployeeResponse;
import kg.nurtelecom.internlabs.employeeservice.service.EmployeeService;
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
    }

    @Override
    public List<EmployeeResponse> findAllEmployees() {
        List<Employee> employees = employeeJpaRepository.findAll();
        return employeeMapper.mapToResponseList(employees);
    }
}
