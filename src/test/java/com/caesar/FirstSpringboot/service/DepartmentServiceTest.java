package com.caesar.FirstSpringboot.service;

import com.caesar.FirstSpringboot.entity.Department;
import com.caesar.FirstSpringboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository deptRepo;

    @BeforeEach
    void setUp() {
       Department dept = Department.builder()
               .departmentId(1L)
               .departmentName("SE")
               .departmentCode("0-3")
               .departmentAddress("Goiania")
               .build();
        Mockito.when(deptRepo.findByDepartmentNameIgnoreCase("SE")).thenReturn(dept);
    }

    @Test
    @DisplayName("Valid department name test")
    public void whenDeptNameValid_DeptShouldBeFound(){
      String deptName = "SE";
      Department found = departmentService.findByDepartmentNameIgnoreCase(deptName);

      assertEquals(deptName,found.getDepartmentName());
    }
}