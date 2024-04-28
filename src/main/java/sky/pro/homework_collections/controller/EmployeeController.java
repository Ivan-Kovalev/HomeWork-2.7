package sky.pro.homework_collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.homework_collections.domain.Employee;
import sky.pro.homework_collections.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("passport") Integer passport,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") Integer salary,
                                @RequestParam("department") Integer department) {
        return employeeService.add(passport, firstName, lastName, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("passport") Integer passport) {
        return employeeService.remove(passport);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("passport") Integer passport) {
        return employeeService.find(passport);
    }

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.printAllEmployees();
    }
}
