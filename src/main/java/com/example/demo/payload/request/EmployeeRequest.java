package com.example.demo.payload.request;

public record EmployeeRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String image, // this is photo object and change type
        AddressRequest addressRequest
) {
}
