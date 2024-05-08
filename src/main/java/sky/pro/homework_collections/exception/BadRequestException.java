package sky.pro.homework_collections.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends EmployeeException {

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
