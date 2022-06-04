package com.caesar.FirstSpringboot.service;

import com.caesar.FirstSpringboot.entity.Department;
import com.caesar.FirstSpringboot.repository.DepartmentRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRespository departmentRespository;
    @Override
    public Department AddDepartment(Department obj) {
        return departmentRespository.save(obj);
    }

    @Override
    public List<Department> GetAll() {
        return departmentRespository.findAll();
    }
}
