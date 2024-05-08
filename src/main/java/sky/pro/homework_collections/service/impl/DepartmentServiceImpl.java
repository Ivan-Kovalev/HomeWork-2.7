package sky.pro.homework_collections.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.homework_collections.domain.Employee;
import sky.pro.homework_collections.exception.EmployeeNotFoundException;
import sky.pro.homework_collections.service.DepartmentService;
import sky.pro.homework_collections.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryForDep(Integer department) {
        Optional<Employee> max = employeeService.printAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparingInt(Employee::getSalary));

        return max.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник c максимальной зп не найден"));
    }

    @Override
    public Employee findMinSalaryForDep(Integer department) {
        Optional<Employee> min = employeeService.printAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparingInt(Employee::getSalary));

        return min.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник c минимальной зп не найден"));
    }

    @Override
    public List<Employee> getEmployeesForDepartment(Integer department) {
        return employeeService.printAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.printAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }


}
