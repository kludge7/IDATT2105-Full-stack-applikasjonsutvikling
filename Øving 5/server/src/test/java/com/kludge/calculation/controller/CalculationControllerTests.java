package com.kludge.calculation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.kludge.calculation.services.CalculationService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculationController.class)
public class CalculationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculationService calculationService;

    @SuppressWarnings("null")
    @Test
    @WithMockUser(username="user",roles={"USER"})
    public void getAllCalculationsShouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/calculations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}