package com.university.domain;

import java.util.List;

public interface DepartmentRepository {
    Department getEntity(int id);
    Department getDepartmentByName(String name);
    void editDepartment(Department updatedEntity);
    void removeDepartment(Department updatedEntity);
    List<Department> getDepartments();
    void addDepartment(Department department);
}
