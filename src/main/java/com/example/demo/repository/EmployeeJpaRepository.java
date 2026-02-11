package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByPhoneNumber(String phoneNumber);

    Optional<Employee> findByFirstnameAndLastname(String firstname, String lastname);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

    void deleteByEmail(String email);

    List<Employee> findAllByFirstname(String firstname);
}
