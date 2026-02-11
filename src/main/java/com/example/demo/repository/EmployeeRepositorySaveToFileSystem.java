package com.example.demo.repository;

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
    public EmployeeResponse save(EmployeeRequest employeeRequest) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE, true))) {
            bufferedWriter.write(employeeRequest.firstName());
            bufferedWriter.write(employeeRequest.lastName());
            bufferedWriter.write(employeeRequest.phoneNumber());
            bufferedWriter.write(employeeRequest.email());
            bufferedWriter.write(employeeRequest.image());
            bufferedWriter.write(employeeRequest.addressRequest().toString());
            bufferedWriter.write("\n");

            return new EmployeeResponse (
                    employeeRequest.firstName(),
                    employeeRequest.lastName(),
                    employeeRequest.phoneNumber(),
                    employeeRequest.email(),
                    employeeRequest.image(),
                    new AddressResponse(
                            employeeRequest.addressRequest().city(),
                            employeeRequest.addressRequest().street()
                    )
            );
        } catch (IOException ioe) {
            throw new IOException(ioe.getMessage());
        }
    }
}
