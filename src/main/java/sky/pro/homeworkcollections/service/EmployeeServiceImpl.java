package sky.pro.homeworkcollections.service;

import org.springframework.stereotype.Service;
import sky.pro.homeworkcollections.domain.Employee;
import sky.pro.homeworkcollections.exception.EmployeeAlreadyAddedException;
import sky.pro.homeworkcollections.exception.EmployeeNotFoundException;
import sky.pro.homeworkcollections.exception.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int employeeSize = 3;
    private final Map<String, Employee> employeeMap = new HashMap<>(employeeSize);

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.size() >= employeeSize) {
            throw new EmployeeStorageIsFullException("Список сотрудников полон");
        }
        if (employeeMap.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employeeMap.put(firstName + lastName, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(firstName + lastName)) {
            employeeMap.remove(firstName + lastName);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(firstName + lastName)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }
}
