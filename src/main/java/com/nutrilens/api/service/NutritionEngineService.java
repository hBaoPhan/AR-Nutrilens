package com.nutrilens.api.service;

import com.nutrilens.api.dto.request.MultiVolumetricNutritionRequestDTO;
import com.nutrilens.api.dto.request.VolumetricNutritionRequestDTO;
import com.nutrilens.api.dto.response.FoodItemResponseDTO;
import com.nutrilens.api.dto.response.MultiNutritionAnalysisResponseDTO;
import com.nutrilens.api.dto.response.NutritionAnalysisResponseDTO;

import java.util.List;

public interface NutritionEngineService {
    NutritionAnalysisResponseDTO analyzeVolumetricPortion(VolumetricNutritionRequestDTO request);
    MultiNutritionAnalysisResponseDTO analyzeMultiVolumetricPortion(MultiVolumetricNutritionRequestDTO request);
    List<FoodItemResponseDTO> getActiveFoods(String category);
}
