package com.caesar.FirstSpringboot.controller;

import com.caesar.FirstSpringboot.entity.Department;
import com.caesar.FirstSpringboot.repository.DepartmentRespository;
import com.caesar.FirstSpringboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/api/create")
    public Department AddDepartment(@RequestBody Department obj){
        return departmentService.AddDepartment(obj);
    }

    @GetMapping("/api/list")
    public List<Department> GetAll(){
        return departmentService.GetAll();
    }
}
