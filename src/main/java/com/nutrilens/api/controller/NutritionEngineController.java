package com.nutrilens.api.controller;

import com.nutrilens.api.dto.request.VolumetricNutritionRequestDTO;
import com.nutrilens.api.dto.response.FoodItemResponseDTO;
import com.nutrilens.api.dto.response.NutritionAnalysisResponseDTO;
import com.nutrilens.api.service.NutritionEngineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nutrition")
@RequiredArgsConstructor
public class NutritionEngineController {

    private final NutritionEngineService nutritionEngineService;

    public NutritionEngineController(NutritionEngineService nutritionEngineService) {
        this.nutritionEngineService = nutritionEngineService;
    }

    @PostMapping("/volumetric-analyze")
    public ResponseEntity<NutritionAnalysisResponseDTO> analyzePortion(
            @Valid @RequestBody VolumetricNutritionRequestDTO request) {
        NutritionAnalysisResponseDTO response = nutritionEngineService.analyzeVolumetricPortion(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/foods")
    public ResponseEntity<List<FoodItemResponseDTO>> getFoods(
            @RequestParam(required = false) String category) {
        List<FoodItemResponseDTO> foods = nutritionEngineService.getActiveFoods(category);
        return ResponseEntity.ok(foods);
    }
}
