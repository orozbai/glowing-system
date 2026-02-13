package kg.nurtelecom.internlabs.employeeservice.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import kg.nurtelecom.internlabs.employeeservice.entity.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByEmailEmployee(String email);
    Optional<Employee> findByPhoneNumberEmployee(String phoneNumber);

    Optional<Employee> findByFirstNameEmployeeAndLastNameEmployee(String firstname, String lastname);

    boolean existsByEmailEmployee(String email);
    boolean existsByPhoneNumberEmployee(String phoneNumber);

    void deleteByEmailEmployee(String email);

    List<Employee> findAllByFirstNameEmployee(String firstname);
}
