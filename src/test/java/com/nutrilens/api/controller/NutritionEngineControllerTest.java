package com.nutrilens.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nutrilens.api.config.SecurityConfig;
import com.nutrilens.api.dto.request.VolumetricNutritionRequestDTO;
import com.nutrilens.api.dto.response.NutritionAnalysisResponseDTO;
import com.nutrilens.api.service.NutritionEngineService;
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

@WebMvcTest(NutritionEngineController.class)
@Import(SecurityConfig.class)
class NutritionEngineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private NutritionEngineService nutritionEngineService;

    @Test
    @DisplayName("Should return 200 OK when request payload is valid")
    void testValidRequestReturns200() throws Exception {
        NutritionAnalysisResponseDTO mockResponse = NutritionAnalysisResponseDTO.builder()
                .foodName("Cơm trắng")
                .effectiveVolumeCm3(new BigDecimal("200.00"))
                .estimatedWeightGrams(new BigDecimal("170.00"))
                .totalCaloriesKcal(new BigDecimal("221.0"))
                .proteinGrams(new BigDecimal("4.59"))
                .carbGrams(new BigDecimal("47.94"))
                .fatGrams(new BigDecimal("0.51"))
                .runningMinutesNeeded(22)
                .briskWalkingMinutesNeeded(48)
                .build();

        when(nutritionEngineService.analyzeVolumetricPortion(any(VolumetricNutritionRequestDTO.class)))
                .thenReturn(mockResponse);

        VolumetricNutritionRequestDTO validRequest = VolumetricNutritionRequestDTO.builder()
                .foodCode("RICE_WHITE_COOKED")
                .volumeCm3(new BigDecimal("200.00"))
                .portionRatio(new BigDecimal("1.00"))
                .userWeightKg(new BigDecimal("65.0"))
                .build();

        mockMvc.perform(post("/api/v1/nutrition/volumetric-analyze")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.foodName").value("Cơm trắng"))
                .andExpect(jsonPath("$.totalCaloriesKcal").value(221.0))
                .andExpect(jsonPath("$.runningMinutesNeeded").value(22));
    }

    @Test
    @DisplayName("Should reject invalid request with 400 Bad Request when volume is negative or zero")
    void testInvalidRequestFailsValidation() throws Exception {
        VolumetricNutritionRequestDTO invalidRequest = VolumetricNutritionRequestDTO.builder()
                .foodCode("") // Blank foodCode
                .volumeCm3(new BigDecimal("-10.00")) // Negative volume
                .portionRatio(new BigDecimal("2.50")) // Exceeds 100%
                .userWeightKg(new BigDecimal("20.0")) // Below 30kg minimum
                .build();

        mockMvc.perform(post("/api/v1/nutrition/volumetric-analyze")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("VALIDATION_FAILED"))
                .andExpect(jsonPath("$.validationErrors.foodCode").exists())
                .andExpect(jsonPath("$.validationErrors.volumeCm3").exists())
                .andExpect(jsonPath("$.validationErrors.portionRatio").exists())
                .andExpect(jsonPath("$.validationErrors.userWeightKg").exists());
    }
}
