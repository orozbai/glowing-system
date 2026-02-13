package kg.nurtelecom.internlabs.employeeservice.repository;

import kg.nurtelecom.internlabs.employeeservice.mapper.EmployeeMapper;
import kg.nurtelecom.internlabs.employeeservice.payload.request.EmployeeRequest;
import kg.nurtelecom.internlabs.employeeservice.payload.response.EmployeeResponse;
import kg.nurtelecom.internlabs.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<EmployeeRequest> entity =
                new HttpEntity<>(employeeRequest, headers);

        ResponseEntity<EmployeeResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                EmployeeResponse.class
        );

        return response.getBody();
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
