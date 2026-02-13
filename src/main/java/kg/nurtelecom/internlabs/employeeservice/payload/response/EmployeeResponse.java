package kg.nurtelecom.internlabs.employeeservice.payload.response;

public record EmployeeResponse(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String image, // this is photo object and change type
        AddressResponse addressResponse
) {
}
