package com.university.application;

import com.university.domain.Department;
import com.university.domain.DepartmentRepository;
import com.university.domain.Employee;
import com.university.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Department getRecordDepartments(int id) {return departmentRepository.getEntity(id);}
    @Override
    public Department getDepartmentByName(String name) {return departmentRepository.getDepartmentByName(name);}
    @Override
    public void editDepartment(Department department) {departmentRepository.editDepartment(department);}
    @Override
    public void addRecordDepartment(Department department) {
        departmentRepository.addDepartment(department);
    }
    @Override
    public void deleteRecordDepartments(Department department) {
        departmentRepository.removeDepartment(department);
    }
    @Override
    public List<Department> getRecordsDepartments() {
        return departmentRepository.getDepartments();
    }

    @Override
    public Employee getRecordEmployees(int id) {
        return employeeRepository.getEntity(id);
    }
    @Override
    public Employee getEmployeeByFIO(String FIO) {return employeeRepository.getEmployeeByFIO(FIO);}
    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee);
    }
    @Override
    public void addRecordEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }
    @Override
    public void deleteRecordEmployees(Employee employee) {
        employeeRepository.removeEmployee(employee);
    }
    @Override
    public List<Employee> getRecordsEmployees() {
        return employeeRepository.getEmployees();
    }
}