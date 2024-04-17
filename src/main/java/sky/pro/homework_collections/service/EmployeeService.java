package sky.pro.homework_collections.service;

import sky.pro.homework_collections.domain.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    Employee add(Integer passport, String firstName, String lastName, Integer salary, Integer department);

    Employee remove(Integer passport);

    Employee find(Integer passport);

    Collection<Employee> printAllEmployees();
}
