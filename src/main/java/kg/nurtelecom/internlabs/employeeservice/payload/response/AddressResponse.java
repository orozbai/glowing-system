package kg.nurtelecom.internlabs.employeeservice.payload.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddressResponse(
        String city,
        String street,
        String houseNumber,
        String apartment

) {

}
