package sky.pro.homework_collections.domain;

import java.util.Objects;

public class Employee {
    private Integer passport;
    private String firstName;
    private String lastName;
    private final String name;
    private Integer salary;
    private Integer department;

    public Employee(Integer passport, String firstName, String lastName, Integer salary, Integer department) {
        this.passport = passport;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = firstName + " " + lastName;
        this.salary = salary;
        this.department = department;
    }

    public Integer getPassport() {
        return passport;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setPassport(Integer passport) {
        this.passport = passport;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(passport, employee.passport) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport, firstName, lastName, name, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "passport=" + passport +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
