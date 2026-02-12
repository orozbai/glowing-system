package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.payload.request.EmployeeRequest;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service("remote")
public class EmployeeRepositorySendToOtherBackend implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final RestTemplate restTemplate;

    @Value("${remote.backend.url}")
    private String url;


    public EmployeeRepositorySendToOtherBackend(
            EmployeeMapper employeeMapper,
            RestTemplate restTemplate
    ) {
        this.employeeMapper = employeeMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        Employee employee = employeeMapper.mapToEmployee(employeeRequest);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        if (employeeRequest.image() != null && !employeeRequest.image().isBlank()) {
            File imageFile = new File(employeeRequest.image());
            if (imageFile.exists()) {
                body.add("photoEmployee", new FileSystemResource(imageFile));
            }
        }

        HttpHeaders jsonHeaders = new HttpHeaders();
        jsonHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Employee> employeePart = new HttpEntity<>(employee, jsonHeaders);
        body.add("employee", employeePart);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<Employee> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Employee.class
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Remote backend rejected employee save: " + response.getStatusCode());
        }

        Employee savedEmployee = Optional.ofNullable(response.getBody())
                .orElseThrow(() -> new RuntimeException(
                        "Remote backend returned empty body after successful save"
                ));

        return employeeMapper.mapToResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponse> findAllEmployees() {
        ResponseEntity<List<EmployeeResponse>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Remote backend rejected employee read: " + response.getStatusCode());
        }

        return Optional.ofNullable(response.getBody()).orElse(List.of());
    }
}
