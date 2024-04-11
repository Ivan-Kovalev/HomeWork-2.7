package sky.pro.homework_collections.service;

import sky.pro.homework_collections.domain.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    Employee add(String firstName, String lastName, Integer passport);

    Employee remove(Integer passport);

    String find(Integer passport);

    Collection<Employee> printAllEmployees();
}
