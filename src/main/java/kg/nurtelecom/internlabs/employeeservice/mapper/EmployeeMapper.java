package kg.nurtelecom.internlabs.employeeservice.mapper;

import kg.nurtelecom.internlabs.employeeservice.entity.Address;
import kg.nurtelecom.internlabs.employeeservice.entity.Employee;
import kg.nurtelecom.internlabs.employeeservice.payload.request.AddressRequest;
import kg.nurtelecom.internlabs.employeeservice.payload.request.EmployeeRequest;
import kg.nurtelecom.internlabs.employeeservice.payload.response.AddressResponse;
import kg.nurtelecom.internlabs.employeeservice.payload.response.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // Request to Entity mapping
    @Mapping(source = "firstName", target = "firstNameEmployee")
    @Mapping(source = "lastName", target = "lastNameEmployee")
    @Mapping(source = "email", target = "emailEmployee")
    @Mapping(source = "phoneNumber", target = "phoneNumberEmployee")
    @Mapping(source = "image", target = "imageEmployee")
    @Mapping(source = "addressRequest", target = "address")
    Employee mapToEmployee(EmployeeRequest employeeRequest);

    Address mapToAddress(AddressRequest addressRequest);

    // Entity to Response mapping
    @Mapping(source = "firstNameEmployee", target = "firstName")
    @Mapping(source = "lastNameEmployee", target = "lastName")
    @Mapping(source = "emailEmployee", target = "email")
    @Mapping(source = "phoneNumberEmployee", target = "phoneNumber")
    @Mapping(source = "imageEmployee", target = "image")
    @Mapping(source = "address", target = "addressResponse")
    EmployeeResponse mapToResponse(Employee employee);

    AddressResponse mapToAddressResponse(Address address);

    // mapToResponse for each element
    List<EmployeeResponse> mapToResponseList(List<Employee> employees);
}