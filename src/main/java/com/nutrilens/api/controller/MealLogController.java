package com.nutrilens.api.controller;

import com.nutrilens.api.dto.response.MealLogResponseDTO;
import com.nutrilens.api.service.MealLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nutrition/meal-logs")
@RequiredArgsConstructor
public class MealLogController {

    private final MealLogService mealLogService;

    public MealLogController(MealLogService mealLogService) {
        this.mealLogService = mealLogService;
    }

    @GetMapping
    public ResponseEntity<List<MealLogResponseDTO>> getMealLogs(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String username) {
        List<MealLogResponseDTO> logs = mealLogService.getRecentMealLogs(userId, username);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealLogResponseDTO> getMealLogById(@PathVariable Long id) {
        MealLogResponseDTO mealLog = mealLogService.getMealLogById(id);
        return ResponseEntity.ok(mealLog);
    }
}
