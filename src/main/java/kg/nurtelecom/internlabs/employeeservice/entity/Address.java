package kg.nurtelecom.internlabs.employeeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * JPA entity representing an address.
 *
 * <p>This entity is mapped to the {@code addresses} table and stores
 * address-related information such as city, street, house number,
 * and apartment.</p>
 *
 * <p>The entity is used as part of the domain model and contains
 * only data fields with corresponding getters and setters.</p>
 */
@Entity
@Table(name = "addresses")
public class Address {
    /**
     * Unique identifier of the address.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address", nullable = false)
    private UUID id;
    /**
     * City name.
     */
    @Column(name = "city", nullable = false, length = 100)
    private String city;
    /**
     * Street name.
     */
    @Column(name = "street", nullable = false, length = 100)
    private String street;
    /**
     * House number.
     */
    @Column(name = "house_number", nullable = false, length = 10)
    private String houseNumber;
    /**
     * Apartment number.
     * <p>This field is optional.</p>
     */
    @Column(name = "apartment", length = 10)
    private String apartment;
    /**
     * Default constructor required by JPA.
     */
    public Address() {
    }
    /**
     * Returns the address identifier.
     *
     * @return unique address identifier
     */
    public UUID getId() {
        return id;
    }
    /**
     * Sets the address identifier.
     *
     * @param id unique address identifier
     */
    public void setId(final UUID id) {
        this.id = id;
    }
    /**
     * Returns the city name.
     *
     * @return city name
     */
    public String getCity() {
        return city;
    }
    /**
     * Sets the city name.
     *
     * @param city city name
     */
    public void setCity(final String city) {
        this.city = city;
    }
    /**
     * Returns the street name.
     *
     * @return street name
     */
    public String getStreet() {
        return street;
    }
    /**
     * Sets the street name.
     *
     * @param street street name
     */
    public void setStreet(final String street) {
        this.street = street;
    }
    /**
     * Returns the house number.
     *
     * @return house number
     */
    public String getHouseNumber() {
        return houseNumber;
    }
    /**
     * Sets the house number.
     *
     * @param houseNumber house number
     */
    public void setHouseNumber(final String houseNumber) {
        this.houseNumber = houseNumber;
    }
    /**
     * Returns the apartment number.
     *
     * @return apartment number or {@code null} if not specified
     */
    public String getApartment() {
        return apartment;
    }
    /**
     * Sets the apartment number.
     *
     * @param apartment apartment number
     */
    public void setApartment(final String apartment) {
        this.apartment = apartment;
    }
    /**
     * Returns a string representation of the {@link Address} entity.
     *
     * <p>The returned string contains the values of all address fields,
     * including identifier, city, street, house number, and apartment.</p>
     *
     * @return string representation of the address
     */
    @Override
    public String toString() {
        return "Address{"
                + "id_address=" + id
                + ", city='" + city + '\''
                + ", street='" + street + '\''
                + ", houseNumber='" + houseNumber + '\''
                + ", apartment='" + apartment + '\'' + '}';
    }
}
