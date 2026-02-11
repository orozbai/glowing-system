package com.example.demo.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressRequest(

        @NotBlank(message = "The city is required")
        @Size(max = 100, message = "The city name must not exceed 100 characters")
        String city,

        @NotBlank(message = "The street is required")
        @Size(max = 255, message = "The street name must not exceed 255 characters")
        String street,

        @NotBlank(message = "The house number is required")
        @Size(max = 20, message = "House number must not exceed 10 characters")
        String houseNumber,

        @Size(max = 20, message = "Apartment must not exceed 10 characters")
        String apartment
) {
}
