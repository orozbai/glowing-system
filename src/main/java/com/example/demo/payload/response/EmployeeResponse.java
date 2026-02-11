package com.example.demo.payload.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmployeeResponse(
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String image, // this is photo object and change type
        AddressResponse addressResponse
) {
}
