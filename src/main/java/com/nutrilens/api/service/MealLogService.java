package com.nutrilens.api.service;

import com.nutrilens.api.dto.response.MealLogResponseDTO;

import java.util.List;

public interface MealLogService {
    List<MealLogResponseDTO> getRecentMealLogs(Long userId, String username);
    MealLogResponseDTO getMealLogById(Long id);
}
