package com.caesar.FirstSpringboot.service;

import com.caesar.FirstSpringboot.entity.Department;
import com.caesar.FirstSpringboot.repository.DepartmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRespository departmentRespository;
    @Override
    public Department AddDepartment(Department obj) {
        return departmentRespository.save(obj);
    }

    @Override
    public List<Department> GetAll() {
        return departmentRespository.findAll();
    }

    //"get" IS UTILIZED TO GET THE OPTIONAL ELEMENT, OPTIONAL DUE TO IT POSSIBLY NOT EXISTING
    @Override
    public Department GetSingle(Long departmentId) {
        return departmentRespository.findById(departmentId).get();
    }

    @Override
    public void DeleteDept(Long departmentId) {
        departmentRespository.deleteById(departmentId);
    }
}
