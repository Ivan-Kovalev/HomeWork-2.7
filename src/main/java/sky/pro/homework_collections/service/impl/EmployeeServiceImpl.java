package sky.pro.homework_collections.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import sky.pro.homework_collections.domain.Employee;
import sky.pro.homework_collections.exception.EmployeeAlreadyAddedException;
import sky.pro.homework_collections.exception.EmployeeNotFoundException;
import sky.pro.homework_collections.exception.EmployeeStorageIsFullException;
import sky.pro.homework_collections.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int employeeSize = 10;
    private final Map<Integer, Employee> employeeMap = new HashMap<>(employeeSize);

    @Override
    public Employee add(Integer passport, String firstName, String lastName, Integer salary, Integer department) {
        Employee employee = new Employee(passport, StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, department);
        if (employeeMap.size() >= employeeSize) {
            throw new EmployeeStorageIsFullException("Список сотрудников полон");
        }
        if (employeeMap.containsKey(passport)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employeeMap.put(passport, employee);
        return employee;
    }

    @Override
    public Employee remove(Integer passport) {
        for (Integer key : employeeMap.keySet()) {
            if (key.equals(passport)) {
                Employee employee = employeeMap.get(key);
                employeeMap.remove(key);
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с номером паспорта " + passport + " не найден");
    }

    @Override
    public Employee find(Integer passport) {
        for (Employee value : employeeMap.values()) {
            if (value.getPassport().equals(passport)) {
                return value;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с номером паспорта " + passport + " не найден");
    }

    @Override
    public Collection<Employee> printAllEmployees() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
