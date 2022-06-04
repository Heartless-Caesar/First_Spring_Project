package com.caesar.FirstSpringboot.controller;

import com.caesar.FirstSpringboot.entity.Department;
import com.caesar.FirstSpringboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("api/create")
    public Department AddDepartment(@RequestBody Department obj){
        return departmentService.AddDepartment(obj);
    }

    @GetMapping("/api/list")
    public List<Department> GetAll(){
        return departmentService.GetAll();
    }

    @GetMapping("/api/single/{id}")
    public Department GetSingle(@PathVariable("id") Long departmentId){
        return departmentService.GetSingle(departmentId);
    }

    @DeleteMapping("/api/single/{id}")
    public String DeleteDept(@PathVariable("id") Long departmentId){
        departmentService.DeleteDept(departmentId);
        return "Deleted";
    }

    @PutMapping("/api/single/{id}")
    public Department UpdateDept(@PathVariable("id") Long departmentId, @RequestBody Department obj){
        return departmentService.UpdateDept(departmentId,obj);
    }
}
