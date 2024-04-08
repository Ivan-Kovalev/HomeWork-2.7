package sky.pro.homeworkcollections.exception.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sky.pro.homeworkcollections.exception.EmployeeAlreadyAddedException;
import sky.pro.homeworkcollections.exception.EmployeeNotFoundException;
import sky.pro.homeworkcollections.exception.EmployeeStorageIsFullException;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDTO> generateNotFoundException(EmployeeNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setStatus(String.valueOf(exception.getStatus().value()));
        errorDTO.setTime(new Date().toString());

        return new ResponseEntity<ErrorDTO>(errorDTO, exception.getStatus());
    }

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ResponseEntity<ErrorDTO> generateNotFoundException(EmployeeAlreadyAddedException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setStatus(String.valueOf(exception.getStatus().value()));
        errorDTO.setTime(new Date().toString());

        return new ResponseEntity<ErrorDTO>(errorDTO, exception.getStatus());
    }

    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public ResponseEntity<ErrorDTO> generateNotFoundException(EmployeeStorageIsFullException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setStatus(String.valueOf(exception.getStatus().value()));
        errorDTO.setTime(new Date().toString());

        return new ResponseEntity<ErrorDTO>(errorDTO, exception.getStatus());
    }
}
