package com.nutrilens.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nutrilens.api.config.SecurityConfig;
import com.nutrilens.api.dto.request.MultiVolumetricNutritionRequestDTO;
import com.nutrilens.api.dto.request.VolumetricComponentItemDTO;
import com.nutrilens.api.dto.request.VolumetricNutritionRequestDTO;
import com.nutrilens.api.dto.response.ComponentNutritionResultDTO;
import com.nutrilens.api.dto.response.FoodItemResponseDTO;
import com.nutrilens.api.dto.response.MultiNutritionAnalysisResponseDTO;
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

import com.nutrilens.api.dto.response.FoodItemResponseDTO;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Test
    @DisplayName("Should return 200 OK with list of foods for valid category")
    void testGetFoodsReturnsList() throws Exception {
        FoodItemResponseDTO salad = FoodItemResponseDTO.builder()
                .id(1L)
                .foodCode("SALAD_EGG")
                .name("Salad with egg")
                .category("Breakfast")
                .kcal(new BigDecimal("294"))
                .weightG(new BigDecimal("100.00"))
                .volumeCm3(new BigDecimal("180.00"))
                .proteinG(new BigDecimal("25"))
                .carbsG(new BigDecimal("21"))
                .fatG(new BigDecimal("14"))
                .iconType("salad")
                .iconBgColor("#FFEFE6")
                .iconColor("#F37340")
                .isHighlightedMore(false)
                .build();

        when(nutritionEngineService.getActiveFoods(eq("Breakfast"))).thenReturn(List.of(salad));

        mockMvc.perform(get("/api/v1/nutrition/foods?category=Breakfast"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].foodCode").value("SALAD_EGG"))
                .andExpect(jsonPath("$[0].name").value("Salad with egg"))
                .andExpect(jsonPath("$[0].category").value("Breakfast"))
                .andExpect(jsonPath("$[0].kcal").value(294));
    }

    @Test
    @DisplayName("Should return 200 OK when multi-component volumetric request is valid (2 eggs and 1 carrot)")
    void testMultiComponentVolumetricAnalysisReturns200() throws Exception {
        ComponentNutritionResultDTO egg1 = ComponentNutritionResultDTO.builder()
                .foodCode("BOILED_EGG")
                .displayName("Trứng Gà Luộc")
                .foodType("ATOMIC_INGREDIENT")
                .emoji("🥚")
                .effectiveVolumeCm3(new BigDecimal("48.54"))
                .estimatedWeightGrams(new BigDecimal("50.00"))
                .caloriesKcal(new BigDecimal("77.5"))
                .proteinGrams(new BigDecimal("6.50"))
                .carbGrams(new BigDecimal("0.55"))
                .fatGrams(new BigDecimal("5.50"))
                .build();

        ComponentNutritionResultDTO egg2 = ComponentNutritionResultDTO.builder()
                .foodCode("BOILED_EGG")
                .displayName("Trứng Gà Luộc")
                .foodType("ATOMIC_INGREDIENT")
                .emoji("🥚")
                .effectiveVolumeCm3(new BigDecimal("48.54"))
                .estimatedWeightGrams(new BigDecimal("50.00"))
                .caloriesKcal(new BigDecimal("77.5"))
                .proteinGrams(new BigDecimal("6.50"))
                .carbGrams(new BigDecimal("0.55"))
                .fatGrams(new BigDecimal("5.50"))
                .build();

        ComponentNutritionResultDTO carrot = ComponentNutritionResultDTO.builder()
                .foodCode("CARROT")
                .displayName("Cà Rốt Luộc / Tươi")
                .foodType("ATOMIC_INGREDIENT")
                .emoji("🥕")
                .effectiveVolumeCm3(new BigDecimal("120.00"))
                .estimatedWeightGrams(new BigDecimal("100.00"))
                .caloriesKcal(new BigDecimal("41.0"))
                .proteinGrams(new BigDecimal("0.90"))
                .carbGrams(new BigDecimal("9.60"))
                .fatGrams(new BigDecimal("0.20"))
                .build();

        MultiNutritionAnalysisResponseDTO mockResponse = MultiNutritionAnalysisResponseDTO.builder()
                .totalComponentsCount(3)
                .totalEffectiveVolumeCm3(new BigDecimal("217.08"))
                .totalEstimatedWeightGrams(new BigDecimal("200.00"))
                .totalCaloriesKcal(new BigDecimal("196.0"))
                .totalProteinGrams(new BigDecimal("13.90"))
                .totalCarbGrams(new BigDecimal("10.70"))
                .totalFatGrams(new BigDecimal("11.20"))
                .runningMinutesNeeded(20)
                .briskWalkingMinutesNeeded(43)
                .components(List.of(egg1, egg2, carrot))
                .build();

        when(nutritionEngineService.analyzeMultiVolumetricPortion(any(MultiVolumetricNutritionRequestDTO.class)))
                .thenReturn(mockResponse);

        MultiVolumetricNutritionRequestDTO request = MultiVolumetricNutritionRequestDTO.builder()
                .userWeightKg(new BigDecimal("65.0"))
                .components(List.of(
                        VolumetricComponentItemDTO.builder().foodCode("BOILED_EGG").volumeCm3(new BigDecimal("48.54")).portionRatio(BigDecimal.ONE).build(),
                        VolumetricComponentItemDTO.builder().foodCode("BOILED_EGG").volumeCm3(new BigDecimal("48.54")).portionRatio(BigDecimal.ONE).build(),
                        VolumetricComponentItemDTO.builder().foodCode("CARROT").volumeCm3(new BigDecimal("120.00")).portionRatio(BigDecimal.ONE).build()
                ))
                .build();

        mockMvc.perform(post("/api/v1/nutrition/multi-volumetric-analyze")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalComponentsCount").value(3))
                .andExpect(jsonPath("$.totalCaloriesKcal").value(196.0))
                .andExpect(jsonPath("$.components[0].foodCode").value("BOILED_EGG"))
                .andExpect(jsonPath("$.components[2].foodCode").value("CARROT"));
    }
}
