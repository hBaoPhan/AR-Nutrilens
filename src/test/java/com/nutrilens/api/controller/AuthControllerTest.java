package com.nutrilens.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nutrilens.api.config.SecurityConfig;
import com.nutrilens.api.dto.request.LoginRequestDTO;
import com.nutrilens.api.dto.response.AuthResponseDTO;
import com.nutrilens.api.service.AuthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@Import(SecurityConfig.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthService authService;

    @Test
    @DisplayName("Should login successfully with valid credentials and return JWT token")
    void testSuccessfulLogin() throws Exception {
        AuthResponseDTO responseDTO = AuthResponseDTO.builder()
                .token("mocked.jwt.token")
                .tokenType("Bearer")
                .userId(1L)
                .username("user1")
                .fullName("Nguyen Van An")
                .role("ROLE_USER")
                .weightKg(new BigDecimal("65.00"))
                .build();

        when(authService.login(any(LoginRequestDTO.class))).thenReturn(responseDTO);

        LoginRequestDTO request = new LoginRequestDTO();
        request.setUsername("user1");
        request.setPassword("user123");

        mockMvc.perform(post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("mocked.jwt.token"))
                .andExpect(jsonPath("$.username").value("user1"))
                .andExpect(jsonPath("$.role").value("ROLE_USER"))
                .andExpect(jsonPath("$.weightKg").value(65.00));
    }
}
