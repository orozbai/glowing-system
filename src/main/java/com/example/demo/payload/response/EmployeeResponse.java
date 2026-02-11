package com.example.demo.payload.response;

import com.example.demo.payload.request.AddressRequest;

public record EmployeeResponse(
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String image, // this is photo object and change type
        AddressResponse addressResponse
) {
}
