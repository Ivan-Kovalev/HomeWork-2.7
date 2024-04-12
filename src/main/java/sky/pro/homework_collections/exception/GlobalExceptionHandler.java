package sky.pro.homework_collections.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sky.pro.homework_collections.domain.ErrorDTO;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorDTO> generateNotFoundException(EmployeeException exception) {
        return generateException(exception);
    }

    private static ResponseEntity<ErrorDTO> generateException(EmployeeException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setStatus(String.valueOf(exception.getStatus().value()));
        errorDTO.setTime(new Date().toString());

        return new ResponseEntity<ErrorDTO>(errorDTO, exception.getStatus());
    }
}
