package com.nutrilens.api.service;

import com.nutrilens.api.dto.request.VolumetricNutritionRequestDTO;
import com.nutrilens.api.dto.response.NutritionAnalysisResponseDTO;

public interface NutritionEngineService {
    NutritionAnalysisResponseDTO analyzeVolumetricPortion(VolumetricNutritionRequestDTO request);
}
