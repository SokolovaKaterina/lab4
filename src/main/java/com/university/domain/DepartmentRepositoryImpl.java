package com.university.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final ArrayList<Department> departments;
    public DepartmentRepositoryImpl() {
        departments = new ArrayList<Department>();
    }

    @Override
    public Department getEntity(int id) {
        return departments.get(id);
    }
    @Override
    public Department getDepartmentByName(String name) {
        for (Department department : departments) {
            if (department.getName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        return null;
    }
    @Override
    public void editDepartment(Department updatedEntity) {
        for (Department department : departments) {
            if (department.getId() == updatedEntity.getId()) {
                department.updateRecordDepartment(updatedEntity);
            }
        }
    }
    @Override
    public void addDepartment(Department department) {
        departments.add(department);
    }
    @Override
    public void removeDepartment(Department deleteEntity) {
        departments.remove(deleteEntity);
    }
    @Override
    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
