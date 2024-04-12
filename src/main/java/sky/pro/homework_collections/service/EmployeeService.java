package sky.pro.homework_collections.service;

import sky.pro.homework_collections.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, Integer passport);

    Employee remove(Integer passport);

    Employee find(Integer passport);

    Collection<Employee> printAllEmployees();
}
