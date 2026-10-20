package com.nutrilens.api.service;

import com.nutrilens.api.dto.request.CreateMealLogRequestDTO;
import com.nutrilens.api.dto.response.MealLogResponseDTO;

import java.util.List;

public interface MealLogService {
    List<MealLogResponseDTO> getRecentMealLogs(Long userId, String username);
    List<MealLogResponseDTO> getFilteredMealLogs(String username, String date, String mealType);
    MealLogResponseDTO getMealLogById(Long id);
    MealLogResponseDTO createMealLog(CreateMealLogRequestDTO request);
}
