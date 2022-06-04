package com.caesar.FirstSpringboot.repository;

import com.caesar.FirstSpringboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);
}
