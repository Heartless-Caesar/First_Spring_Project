package com.caesar.FirstSpringboot.repository;

import com.caesar.FirstSpringboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentNameIgnoreCase(String departmentName);
}
