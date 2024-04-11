package sky.pro.homework_collections.exception;

import org.springframework.http.HttpStatus;

public abstract class EmployeeException extends RuntimeException {
    public EmployeeException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();
}
