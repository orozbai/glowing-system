package com.example.demo.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee", nullable = false)
    private UUID idEmployee;

    @Column(name = "first_name_employee", nullable = false, length = 100)
    private String firstNameEmployee;

    @Column(name = "last_name_employee", nullable = false, length = 100)
    private String lastNameEmployee;

    @Column(name = "phone_number_employee", nullable = false, length = 15)
    private String phoneNumberEmployee;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String emailEmployee;

    @Column(name = "image", columnDefinition = "TEXT")
    private String imageEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    public Employee() {
    }

    public UUID getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(UUID idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstNameEmployee() {
        return firstNameEmployee;
    }

    public void setFirstNameEmployee(String firstNameEmployee) {
        this.firstNameEmployee = firstNameEmployee;
    }

    public String getLastNameEmployee() {
        return lastNameEmployee;
    }

    public void setLastNameEmployee(String lastNameEmployee) {
        this.lastNameEmployee = lastNameEmployee;
    }

    public String getPhoneNumberEmployee() {
        return phoneNumberEmployee;
    }

    public void setPhoneNumberEmployee(String phoneNumberEmployee) {
        this.phoneNumberEmployee = phoneNumberEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getImageEmployee() {
        return imageEmployee;
    }

    public void setImageEmployee(String imageEmployee) {
        this.imageEmployee = imageEmployee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", firstNameEmployee='" + firstNameEmployee + '\'' +
                ", lastNameEmployee='" + lastNameEmployee + '\'' +
                ", phoneNumberEmployee='" + phoneNumberEmployee + '\'' +
                ", emailEmployee='" + emailEmployee + '\'' +
                ", imageEmployee='" + imageEmployee + '\'' +
                ", address=" + address +
                '}';
    }
}

