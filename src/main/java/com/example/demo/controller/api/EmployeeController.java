package com.example.demo.controller.api;

import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * REST controller for working with employees.
 *
 * <p>Allows you to create employees with the option to select
 * a save method (e.g., to a database, file, etc.).
 */
@RestController
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
     * Creates a new employee.
     *
     * @param request employee data
     * @param saveTo service key, defining the save method
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
            return new ResponseEntity<>((HttpHeaders) null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
