package com.university.domain;

import java.util.List;

public interface EmployeeRepository {

    Employee getEntity(int id);
    Employee getEmployeeByFIO(String FIO);
    void editEmployee(Employee updatedEntity);
    void removeEmployee(Employee updatedEntity);
    List<Employee> getEmployees();
    void addEmployee(Employee employee);
}
