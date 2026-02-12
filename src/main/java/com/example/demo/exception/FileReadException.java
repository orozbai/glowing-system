package com.example.demo.exception;

/**
 * Exception thrown when an error occurs while reading a file.
 *
 * <p>This exception indicates problems such as file access issues,
 * incorrect file format, or I/O errors during file processing.</p>
 */
public class FileReadException extends RuntimeException {
    /**
     * Constructs a new {@code FileReadException}
     * with the specified detail message.
     *
     * @param message the detail message describing the file read error
     */
    public FileReadException(final String message) {
        super(message);
    }
}
