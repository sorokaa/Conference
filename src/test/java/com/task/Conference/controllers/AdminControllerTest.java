package com.task.Conference.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    private AdminController adminController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails(value = "root")
    public void adminPageTest() throws Exception {
        this.mockMvc.perform(get("/admin-page"))
            .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "biba")
    public void accessDeniedTest() throws Exception {
        this.mockMvc.perform(get("/admin-page"))
            .andExpect(status().isForbidden());
    }



}