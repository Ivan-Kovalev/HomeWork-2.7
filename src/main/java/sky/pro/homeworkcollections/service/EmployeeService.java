package sky.pro.homeworkcollections.service;

import sky.pro.homeworkcollections.domain.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Map<String, Employee> getEmployeeMap();
}