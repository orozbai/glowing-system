package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.payload.request.AddressRequest;
import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;

@Component
public class EmployeeMapper {

    public Address mapToAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setCity(addressRequest.city());
        address.setStreet(addressRequest.street());
        return address;
    }

    public Employee mapToEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setFirstname(employeeRequest.firstName());
        employee.setLastname(employeeRequest.lastName());
        employee.setEmail(employeeRequest.email());
        employee.setAddress(mapToAddress(employeeRequest.addressRequest()));
        return employee;
    }
}
