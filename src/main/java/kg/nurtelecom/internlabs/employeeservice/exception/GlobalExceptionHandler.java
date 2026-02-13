package kg.nurtelecom.internlabs.employeeservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the application.
 *
 * <p>This class handles application-specific exceptions and maps them
 * to appropriate HTTP responses. It also logs error details for
 * monitoring and debugging purposes.</p>
 *
 * <p>Handled exceptions include:</p>
 * <ul>
 *     <li>{@link EmployeeNotFoundException}
 *     – returns HTTP 204 NO CONTENT</li>
 *     <li>{@link FileReadException}
 *     – returns HTTP 500 INTERNAL SERVER ERROR</li>
 *     <li>{@link FileWriteException}
 *     – returns HTTP 500 INTERNAL SERVER ERROR</li>
 * </ul>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Logger instance for logging exception handling events in this class.
     *
     * <p>Used to log information and error messages when exceptions
     * are caught by the handler methods.</p>
     */
    private static final Logger LOG =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles {@link EmployeeNotFoundException}.
     *
     * @param e the exception instance
     * @return ResponseEntity with HTTP status 204
     * NO CONTENT and a message
     */
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handleEmployeeNotFoundException(
            final EmployeeNotFoundException e) {
        LOG.info("There is no data in the file {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("В файле нет данных");
    }

    /**
     * Handles {@link FileReadException}.
     *
     * @param e the exception instance
     * @return ResponseEntity with HTTP status 500
     * INTERNAL SERVER ERROR and a message
     */
    @ExceptionHandler(FileReadException.class)
    public ResponseEntity<String> handleFileReadException(
            final FileReadException e) {
        LOG.error("Failed to read file {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Не удалось прочитать данные из файла");
    }

    /**
     * Handles {@link FileWriteException}.
     *
     * @param e the exception instance
     * @return ResponseEntity with HTTP status 500
     * INTERNAL SERVER ERROR and a message
     */
    @ExceptionHandler(FileWriteException.class)
    public ResponseEntity<String> handleFileWriteException(
            final FileWriteException e) {
        LOG.error("Failed to write file {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Не удалось записать данные в файл");
    }

}

