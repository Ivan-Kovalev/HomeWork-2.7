package sky.pro.homework_collections.service;

import sky.pro.homework_collections.domain.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    Employee findMaxSalaryForDep(Integer department);

    Employee findMinSalaryForDep(Integer department);

    List<Employee> printEmployeesForDepartment(Integer department);

    Map<Integer, List<Employee>> findEmployeesByDepartment();
}
