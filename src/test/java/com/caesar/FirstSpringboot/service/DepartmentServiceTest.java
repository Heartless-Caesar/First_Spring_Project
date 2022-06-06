package com.caesar.FirstSpringboot.service;

import com.caesar.FirstSpringboot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void whenDeptNameValid_DeptShouldBeFound(){
      String deptName = "CE";
      Department found = departmentService.findByDepartmentNameIgnoreCase(deptName);

      assertEquals(deptName,found.getDepartmentName());
    }
}