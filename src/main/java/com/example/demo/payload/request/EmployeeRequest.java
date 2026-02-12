package com.example.demo.payload.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


public record EmployeeRequest(

        @NotBlank(message = "The firstName is required.")
        @Size(min = 2, max = 50, message = "The firstName must be from 2 to 50 characters.")
        String firstName,
        @NotBlank(message = "The lastName is required.")
        @Size(min = 2, max = 70, message = "The lastName must be from 2 to 70 characters.")
        String lastName,
        @NotBlank(message = "The email is required.")
        @Email(message = "The email is not a valid email.")
        String email,
        @NotBlank(message = "The phoneNumber is required.")
        @Size(min = 13, max = 13, message = "The phoneNumber must be like +996XXXXXXXXX.")
        String phoneNumber,
        String image, // this is photo object and change type
        @NotNull(message = "The address is required.")
        @Valid
        AddressRequest addressRequest
) {

}
