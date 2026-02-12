package com.example.demo.exception;

/**
 * Exception thrown when an employee cannot be found.
 *
 * <p>This exception is used to indicate that an employee with the specified
 * identifier or parameters does not exist in the system.</p>
 */
public class EmployeeNotFoundException extends RuntimeException {
    /**
     * Constructs a new {@code EmployeeNotFoundException}
     * with the specified detail message.
     *
     * @param message the detail message describing
     *                the reason the employee was not found.
     */
    public EmployeeNotFoundException(final String message) {
        super(message);
    }
}
