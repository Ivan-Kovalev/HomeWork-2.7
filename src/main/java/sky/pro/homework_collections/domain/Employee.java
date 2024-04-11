package sky.pro.homework_collections.domain;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer passport;

    public Employee(String firstName, String lastName, Integer passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    public Integer getPassport() {
        return passport;
    }

    public void setPassport(Integer passport) {
        this.passport = passport;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(passport, employee.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passport);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport=" + passport +
                '}';
    }
}
