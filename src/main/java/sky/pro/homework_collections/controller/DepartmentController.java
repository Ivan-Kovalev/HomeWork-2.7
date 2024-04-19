package sky.pro.homework_collections.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.homework_collections.domain.Employee;
import sky.pro.homework_collections.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryForDep(@RequestParam("departmentId") Integer depId) {
        return departmentService.findMaxSalaryForDep(depId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalaryForDep(@RequestParam("departmentId") Integer depId) {
        return departmentService.findMinSalaryForDep(depId);
    }

    @GetMapping(path = "/all")
    public List<Employee> printAllEmployeesForDep(@RequestParam("departmentId") Integer depId) {
        return departmentService.printEmployeesForDepartment(depId);
    }

    @GetMapping(path = "/all-departments")
    public Map<Integer, List<Employee>> printAllDepartments() {
        return departmentService.findEmployeesByDepartment();
    }
}
