package com.example.demo.exception;

/**
 * Exception thrown when an error occurs while writing to a file.
 *
 * <p>This exception indicates issues such as file access problems,
 * insufficient permissions, or I/O errors during file writing.</p>
 */
public class FileWriteException extends RuntimeException {
    /**
     * Constructs a new {@code FileWriteException}
     * with the specified detail message.
     *
     * @param message the detail message describing the file write error
     */
    public FileWriteException(final String message) {
        super(message);
    }
}
