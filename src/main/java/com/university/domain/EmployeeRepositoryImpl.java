package com.university.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private final ArrayList<Employee> employees;
    public EmployeeRepositoryImpl() {
        employees = new ArrayList<Employee>();
    }

    @Override
    public Employee getEntity(int id) {
        return employees.get(id);
    }
    @Override
    public Employee getEmployeeByFIO(String FIO) {
        for (Employee employee : employees) {
            if (employee.getFIO().equalsIgnoreCase(FIO)) {
                return employee;
            }
        }
        return null;
    }
    @Override
    public void editEmployee(Employee updatedEntity) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == updatedEntity.getId()) {
                employees.get(i).updateRecordEmployee(updatedEntity);
            }
        }
    }
    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    @Override
    public void removeEmployee(Employee deleteEntity) {
        employees.remove(deleteEntity);
    }
    @Override
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
