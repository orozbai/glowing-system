package com.example.demo.entity;


import jakarta.persistence.*;

import java.util.UUID;

/**
 * JPA entity representing an employee.
 *
 * <p>This entity is mapped to the {@code employees} table and contains
 * personal and contact information about an employee, as well as
 * a reference to the associated {@link Address}.</p>
 *
 * <p>The relationship between {@code Employee} and {@code Address}
 * is defined as {@code ManyToOne} with lazy fetching strategy.</p>
 */
@Entity
@Table(name = "employees")
public class Employee {
    /**
     * Unique identifier of the employee.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee", nullable = false)
    private UUID id;
    /**
     * Employee first name.
     */
    @Column(name = "first_name_employee", nullable = false, length = 100)
    private String firstNameEmployee;
    /**
     * Employee last name.
     */
    @Column(name = "last_name_employee", nullable = false, length = 100)
    private String lastNameEmployee;
    /**
     * Employee phone number.
     */
    @Column(name = "phone_number_employee", nullable = false, length = 15)
    private String phoneNumberEmployee;
    /**
     * Employee email address.
     * <p>Must be unique.</p>
     */
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String emailEmployee;
    /**
     * URL or Base64 representation of the employee image.
     */
    @Column(name = "image", columnDefinition = "TEXT")
    private String imageEmployee;
    /**
     * Address associated with the employee.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    /**
     * Default constructor required by JPA.
     */
    public Employee() {
    }

    /**
     * Returns the employee identifier.
     *
     * @return employee ID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the employee identifier.
     *
     * @param id employee ID
     */
    public void setId(final UUID id) {
        this.id = id;
    }

    /**
     * Returns the employee first name.
     *
     * @return first name
     */
    public String getFirstNameEmployee() {
        return firstNameEmployee;
    }

    /**
     * Sets the employee first name.
     *
     * @param firstNameEmployee first name
     */
    public void setFirstNameEmployee(final String firstNameEmployee) {
        this.firstNameEmployee = firstNameEmployee;
    }

    /**
     * Returns the employee last name.
     *
     * @return last name
     */
    public String getLastNameEmployee() {
        return lastNameEmployee;
    }

    /**
     * Sets the employee last name.
     *
     * @param lastNameEmployee last name
     */
    public void setLastNameEmployee(final String lastNameEmployee) {
        this.lastNameEmployee = lastNameEmployee;
    }

    /**
     * Returns the employee phone number.
     *
     * @return phone number
     */
    public String getPhoneNumberEmployee() {
        return phoneNumberEmployee;
    }

    /**
     * Sets the employee phone number.
     *
     * @param phoneNumberEmployee phone number
     */
    public void setPhoneNumberEmployee(final String phoneNumberEmployee) {
        this.phoneNumberEmployee = phoneNumberEmployee;
    }

    /**
     * Returns the employee email address.
     *
     * @return email address
     */
    public String getEmailEmployee() {
        return emailEmployee;
    }

    /**
     * Sets the employee email address.
     *
     * @param emailEmployee email address
     */
    public void setEmailEmployee(final String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    /**
     * Returns the employee image.
     *
     * @return image representation
     */
    public String getImageEmployee() {
        return imageEmployee;
    }

    /**
     * Sets the employee image.
     *
     * @param imageEmployee image representation
     */
    public void setImageEmployee(final String imageEmployee) {
        this.imageEmployee = imageEmployee;
    }

    /**
     * Returns the associated address.
     *
     * @return employee address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the associated address.
     *
     * @param address employee address
     */
    public void setAddress(final Address address) {
        this.address = address;
    }

    /**
     * Returns a string representation of the {@link Employee} entity.
     *
     * <p>The returned string contains the values of all employee fields,
     * including identifier, first name, last name, phone number,
     * email, image and apartment.</p>
     *
     * @return string representation of the employee entity.
     */
    @Override
    public String toString() {
        return "Employee{"
                + "idEmployee=" + id
                + ", firstNameEmployee='" + firstNameEmployee + '\''
                + ", lastNameEmployee='" + lastNameEmployee + '\''
                + ", phoneNumberEmployee='" + phoneNumberEmployee + '\''
                + ", emailEmployee='" + emailEmployee + '\''
                + ", imageEmployee='" + imageEmployee + '\''
                + ", address=" + address
                + '}';
    }
}

