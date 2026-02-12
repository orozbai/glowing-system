package com.example.demo.repository;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.FileReadException;
import com.example.demo.exception.FileWriteException;
import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.AddressResponse;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForArraysOfBoolean;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("file")
public class EmployeeRepositorySaveToFileSystem implements EmployeeService {
    private static final File FILE = new File("employees.txt");

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE, true))) {
            bufferedWriter.write(employeeRequest.firstName());
            bufferedWriter.write(employeeRequest.lastName());
            bufferedWriter.write(employeeRequest.phoneNumber());
            bufferedWriter.write(employeeRequest.email());
            bufferedWriter.write(employeeRequest.image());
            bufferedWriter.write(employeeRequest.addressRequest().toString());

            return new EmployeeResponse (
                    employeeRequest.firstName(),
                    employeeRequest.lastName(),
                    employeeRequest.phoneNumber(),
                    employeeRequest.email(),
                    employeeRequest.image(),
                    new AddressResponse(
                            employeeRequest.addressRequest().city(),
                            employeeRequest.addressRequest().street(),
                            employeeRequest.addressRequest().houseNumber(),
                            employeeRequest.addressRequest().apartment()
                    )
            );
        } catch (IOException ioe) {
            throw new FileWriteException(ioe.getMessage());
        }
    }

    @Override
    public List<EmployeeResponse> findAllEmployees() {
        List<EmployeeResponse> employees = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {

            while (true) {
                String firstName = bufferedReader.readLine();
                if (firstName == null) break;

                String lastName = bufferedReader.readLine();
                String phoneNumber = bufferedReader.readLine();
                String email = bufferedReader.readLine();
                String image = bufferedReader.readLine();
                String address = bufferedReader.readLine();
                String[] lineAddress = mapLineToAddressResponse(address);
                EmployeeResponse employeeResponse = new EmployeeResponse(
                        firstName,
                        lastName,
                        phoneNumber,
                        email,
                        image,
                        new AddressResponse(
                                lineAddress[0].split("=")[1],
                                lineAddress[1].split("=")[1],
                                lineAddress[2].split("=")[1],
                                lineAddress[3].split("=")[1]
                        )
                );
                employees.add(employeeResponse);
            }
            if (employees.isEmpty()) {
                throw new EmployeeNotFoundException("Unable to find employees");
            }
            return employees;
        } catch (IOException ioe) {
            throw new FileReadException(ioe.getMessage());
        }
    }

    public String[] mapLineToAddressResponse(String address) {
        address = address
                .replace("AddressRequest[", "")
                .replace("]", "");

        return address.split(", ");
    }

}
