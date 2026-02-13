package kg.nurtelecom.internlabs.employeeservice.controller.api;

import kg.nurtelecom.internlabs.employeeservice.payload.request.EmployeeRequest;
import kg.nurtelecom.internlabs.employeeservice.payload.response.EmployeeResponse;
import kg.nurtelecom.internlabs.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * REST controller for working with employees.
 *
 * <p>Allows you to create employees with the option to select
 * a save method (e.g., to a database, file, etc.).
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/employees")
public final class EmployeeController {
    /**
     * implementations of EmployeeService {@link EmployeeService},
     * where the key is the input storage.
     */
    private final Map<String, EmployeeService> services;

    /**
     * Creates an employee controller.
     *
     * @param employeeService map of employee retention services
     */
    public EmployeeController(
            final Map<String, EmployeeService> employeeService) {
        this.services = employeeService;
    }

    /**
     * Returns a list of employees from the specified data source.
     *
     * <p>The data source is selected dynamically based on the {@code source}
     * request parameter. The corresponding
     * {@link EmployeeService} implementation
     * is used to retrieve employee data.</p>
     *
     * @param source the identifier of the data source used to fetch employees
     * @return {@link ResponseEntity} containing
     * a list of {@link EmployeeResponse}
     * objects and HTTP status {@code 200 OK}
     */
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getEmployees(
            @RequestParam final String source) {
        EmployeeService service = services.get(source);
        List<EmployeeResponse> employees = service.findAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    /**
     * Creates a new employee.
     *
     * @param request employee data
     * @param saveTo  service key, defining the save method
     * @return the created employee or {@code 400 Bad Request},
     * if the save service is not found
     */
    @PostMapping
    public ResponseEntity<EmployeeResponse> createDevelopers(
            @Valid @RequestBody final EmployeeRequest request,
            @RequestParam final String saveTo
    ) {
        try {
            EmployeeService service = services.get(saveTo);
            if (service == null) {
                return ResponseEntity.badRequest().build();
            }

            EmployeeResponse response = service.save(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((HttpHeaders) null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
