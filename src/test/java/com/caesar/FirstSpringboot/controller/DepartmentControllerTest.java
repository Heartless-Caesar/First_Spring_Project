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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    private Department department;

    @MockBean
    private DepartmentService departmentService;

    @BeforeEach
    void setUp(){
        department = Department.builder()
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
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getSingle() throws Exception {

        Mockito.when(departmentService.GetSingle(1L))
                .thenReturn(department);

        mockMvc.perform(get("/api/single/1")
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()))
        ;
    }
}