package com.caesar.FirstSpringboot.controller;

import com.caesar.FirstSpringboot.entity.Department;
import com.caesar.FirstSpringboot.error.NotFoundError;
import com.caesar.FirstSpringboot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("api/create")
    public Department AddDepartment(@Valid @RequestBody Department obj){
        //Logger example, this can be used effectively when debugging
        LOGGER.info("Added logger inside the POST request controller");

        return departmentService.AddDepartment(obj);
    }

    @GetMapping("/api/list")
    public List<Department> GetAll(){
        return departmentService.GetAll();
    }

    @GetMapping("/api/single/{id}")
    public Department GetSingle(@PathVariable("id") Long departmentId) throws NotFoundError {
        return departmentService.GetSingle(departmentId);
    }

    @DeleteMapping("/api/delete/{id}")
    public String DeleteDept(@PathVariable("id") Long departmentId){
        departmentService.DeleteDept(departmentId);
        return "Deleted";
    }

    @PutMapping("/api/edit/{id}")
    public Department UpdateDept(@PathVariable("id") Long departmentId, @RequestBody Department obj){
        return departmentService.UpdateDept(departmentId,obj);
    }

    @GetMapping("/api/specific/{name}")
    public Department findByDepartmentNameIgnoreCase(@PathVariable("name") String deptName){
        return departmentService.findByDepartmentNameIgnoreCase(deptName);
    }
}
