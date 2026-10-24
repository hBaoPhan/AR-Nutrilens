package com.nutrilens.api.service;

import com.nutrilens.api.dto.request.CreateNutritionTipRequestDTO;
import com.nutrilens.api.dto.response.NutritionTipResponseDTO;

import java.util.List;

public interface NutritionTipService {

    List<NutritionTipResponseDTO> getAllActiveTips(String targetGoal);

    NutritionTipResponseDTO getRandomTip();

    NutritionTipResponseDTO createTip(CreateNutritionTipRequestDTO request);

    NutritionTipResponseDTO getTipById(Long id);

    void deleteTip(Long id);
}
