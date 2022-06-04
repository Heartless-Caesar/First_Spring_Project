package com.caesar.FirstSpringboot.service;

import com.caesar.FirstSpringboot.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department AddDepartment(Department obj);

    List<Department> GetAll();

    Department GetSingle(Long Id);

    void DeleteDept(Long departmentId);

    Department UpdateDept(Long departmentId, Department obj);
}