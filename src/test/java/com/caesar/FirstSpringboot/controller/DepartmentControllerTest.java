package com.caesar.FirstSpringboot.controller;

import com.caesar.FirstSpringboot.entity.Department;
import com.caesar.FirstSpringboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @BeforeEach
    void setUp(){
        Department department = Department.builder()
                .departmentId(1L)
                .departmentName("FSX")
                .departmentCode("0-11")
                .departmentAddress("Galaxy-65")
                .build();
    }

    @Test
    void addDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentId(1L)
                .departmentName("FSX")
                .departmentCode("0-11")
                .departmentAddress("Galaxy-65")
                .build();

        Mockito.when(departmentService.AddDepartment(inputDepartment))
                .thenReturn(inputDepartment);

        mockMvc.perform(post("/api/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"FSX\",\n" +
                        "\t\"departmentCode\":\"0-11\",\n" +
                        "\t\"departmentAddress\":\"Galaxy-65\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void getSingle() {
    }
}