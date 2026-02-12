package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.payload.request.AddressRequest;
import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.AddressResponse;
import com.example.demo.payload.response.EmployeeResponse;

@Component
public class EmployeeMapper {

    public Address mapToAddress(AddressRequest addressRequest) {
        if (addressRequest == null) return null;

        Address address = new Address();
        address.setCity(addressRequest.city());
        address.setStreet(addressRequest.street());
        address.setApartment(addressRequest.apartment());
        address.setHouseNumber(addressRequest.houseNumber());
        return address;
    }

    public Employee mapToEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setFirstNameEmployee(employeeRequest.firstName());
        employee.setLastNameEmployee(employeeRequest.lastName());
        employee.setEmailEmployee(employeeRequest.email());
        employee.setPhoneNumberEmployee(employeeRequest.phoneNumber());
        employee.setImageEmployee(employeeRequest.image());
        employee.setAddress(mapToAddress(employeeRequest.addressRequest()));
        return employee;
    }

    public AddressResponse mapToAddressResponse(Address address) {
        if (address != null) {
            return new AddressResponse(
                address.getCity(),
                address.getStreet(),
                address.getHouseNumber(),
                address.getApartment()
            );
        } else return null;
    }

    public EmployeeResponse mapToResponse(Employee employee) {
        return new EmployeeResponse(
            employee.getFirstNameEmployee(),
            employee.getLastNameEmployee(),
            employee.getEmailEmployee(),
            employee.getPhoneNumberEmployee(),
            employee.getImageEmployee(),
            mapToAddressResponse(employee.getAddress())
        );
    }
}
