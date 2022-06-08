package com.caesar.FirstSpringboot.repository;

import com.caesar.FirstSpringboot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository deptRepo;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("EEG")
                .departmentCode("0-22")
                .departmentAddress("Aus")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenValidId_ReturnDept(){
      Department department = deptRepo.findById(1L).get();
      assertEquals(department.getDepartmentName(),"EEG");
    }
}