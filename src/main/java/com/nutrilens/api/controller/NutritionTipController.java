package com.nutrilens.api.controller;

import com.nutrilens.api.dto.request.CreateNutritionTipRequestDTO;
import com.nutrilens.api.dto.response.NutritionTipResponseDTO;
import com.nutrilens.api.service.NutritionTipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tips")
@RequiredArgsConstructor
public class NutritionTipController {

    private final NutritionTipService nutritionTipService;

    public NutritionTipController(NutritionTipService nutritionTipService) {
        this.nutritionTipService = nutritionTipService;
    }

    @GetMapping
    public ResponseEntity<List<NutritionTipResponseDTO>> getAllTips(
            @RequestParam(required = false) String targetGoal) {
        List<NutritionTipResponseDTO> tips = nutritionTipService.getAllActiveTips(targetGoal);
        return ResponseEntity.ok(tips);
    }

    @GetMapping("/random")
    public ResponseEntity<NutritionTipResponseDTO> getRandomTip() {
        NutritionTipResponseDTO tip = nutritionTipService.getRandomTip();
        return ResponseEntity.ok(tip);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutritionTipResponseDTO> getTipById(@PathVariable Long id) {
        NutritionTipResponseDTO tip = nutritionTipService.getTipById(id);
        return ResponseEntity.ok(tip);
    }

    @PostMapping
    public ResponseEntity<NutritionTipResponseDTO> createTip(@Valid @RequestBody CreateNutritionTipRequestDTO request) {
        NutritionTipResponseDTO created = nutritionTipService.createTip(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        nutritionTipService.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}
