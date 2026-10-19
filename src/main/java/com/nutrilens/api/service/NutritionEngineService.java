package com.nutrilens.api.service;

import com.nutrilens.api.dto.request.VolumetricNutritionRequestDTO;
import com.nutrilens.api.dto.response.FoodItemResponseDTO;
import com.nutrilens.api.dto.response.NutritionAnalysisResponseDTO;

import java.util.List;

public interface NutritionEngineService {
    NutritionAnalysisResponseDTO analyzeVolumetricPortion(VolumetricNutritionRequestDTO request);
    List<FoodItemResponseDTO> getActiveFoods(String category);
}
