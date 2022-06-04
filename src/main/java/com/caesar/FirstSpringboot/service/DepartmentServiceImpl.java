package com.caesar.FirstSpringboot.service;

import com.caesar.FirstSpringboot.entity.Department;
import com.caesar.FirstSpringboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department AddDepartment(Department obj) {
        return departmentRepository.save(obj);
    }

    @Override
    public List<Department> GetAll() {
        return departmentRepository.findAll();
    }

    //"get" IS UTILIZED TO GET THE OPTIONAL ELEMENT, OPTIONAL DUE TO IT POSSIBLY NOT EXISTING
    @Override
    public Department GetSingle(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void DeleteDept(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department UpdateDept(Long departmentId, Department obj) {
        Department deptDb = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(deptDb.getDepartmentName()) && !"".equalsIgnoreCase(deptDb.getDepartmentName())){
            deptDb.setDepartmentName(obj.getDepartmentName());
        }

        if(Objects.nonNull(deptDb.getDepartmentAddress()) && !"".equalsIgnoreCase(deptDb.getDepartmentAddress())){
            deptDb.setDepartmentAddress(obj.getDepartmentAddress());
        }

        if(Objects.nonNull(deptDb.getDepartmentCode()) && !"".equalsIgnoreCase(deptDb.getDepartmentCode())){
            deptDb.setDepartmentCode(obj.getDepartmentCode());
        }

        return departmentRepository.save(deptDb);
    }

    @Override
    public Department findByDepartmentNameIgnoreCase(String deptName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(deptName);
    }
}
