package com.nutrilens.api.service.impl;

import com.nutrilens.api.dto.request.VolumetricNutritionRequestDTO;
import com.nutrilens.api.dto.response.NutritionAnalysisResponseDTO;
import com.nutrilens.api.entity.FoodDensity;
import com.nutrilens.api.exception.EntityNotFoundException;
import com.nutrilens.api.repository.FoodDensityRepository;
import com.nutrilens.api.service.NutritionEngineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
@Slf4j
public class NutritionEngineServiceImpl implements NutritionEngineService {

    private final FoodDensityRepository foodDensityRepository;

    public NutritionEngineServiceImpl(FoodDensityRepository foodDensityRepository) {
        this.foodDensityRepository = foodDensityRepository;
    }

    // Standard medical MET values
    private static final BigDecimal RUNNING_MET = BigDecimal.valueOf(8.3);   // ~8 km/h running
    private static final BigDecimal WALKING_MET = BigDecimal.valueOf(3.8);   // ~5 km/h brisk walking
    private static final BigDecimal OXYGEN_CONSUMPTION_FACTOR = BigDecimal.valueOf(3.5);
    private static final BigDecimal MET_DIVISOR = BigDecimal.valueOf(200);

    @Override
    @Transactional(readOnly = true)
    public NutritionAnalysisResponseDTO analyzeVolumetricPortion(VolumetricNutritionRequestDTO request) {
        FoodDensity food = foodDensityRepository.findByFoodCodeAndIsActiveTrue(request.getFoodCode())
                .orElseThrow(() -> new EntityNotFoundException("Food density record not found for: " + request.getFoodCode()));

        // 1. Effective Volume: V_eff = V_scanned * portionRatio
        BigDecimal effectiveVolume = request.getVolumeCm3()
                .multiply(request.getPortionRatio())
                .setScale(2, RoundingMode.HALF_UP);

        // 2. Estimated Weight: m = V_eff * density (g/cm3)
        BigDecimal estimatedWeightGrams = effectiveVolume
                .multiply(food.getDensityGramsPerCm3())
                .setScale(2, RoundingMode.HALF_UP);

        // 3. Macronutrient conversion ratio per 100g
        BigDecimal factorPerHundred = estimatedWeightGrams.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);

        BigDecimal totalKcal = food.getKcalPer100g().multiply(factorPerHundred).setScale(1, RoundingMode.HALF_UP);
        BigDecimal protein = food.getProteinPer100g().multiply(factorPerHundred).setScale(2, RoundingMode.HALF_UP);
        BigDecimal carb = food.getCarbPer100g().multiply(factorPerHundred).setScale(2, RoundingMode.HALF_UP);
        BigDecimal fat = food.getFatPer100g().multiply(factorPerHundred).setScale(2, RoundingMode.HALF_UP);

        // 4. Burn Visualizer calculation via MET formula
        int runningMinutes = computeExerciseDuration(totalKcal, RUNNING_MET, request.getUserWeightKg());
        int walkingMinutes = computeExerciseDuration(totalKcal, WALKING_MET, request.getUserWeightKg());

        return NutritionAnalysisResponseDTO.builder()
                .foodName(food.getDisplayName())
                .effectiveVolumeCm3(effectiveVolume)
                .estimatedWeightGrams(estimatedWeightGrams)
                .totalCaloriesKcal(totalKcal)
                .proteinGrams(protein)
                .carbGrams(carb)
                .fatGrams(fat)
                .runningMinutesNeeded(runningMinutes)
                .briskWalkingMinutesNeeded(walkingMinutes)
                .build();
    }

    private int computeExerciseDuration(BigDecimal totalKcal, BigDecimal met, BigDecimal userWeightKg) {
        // Cal/min = (MET * 3.5 * Weight) / 200
        BigDecimal calPerMinute = met.multiply(OXYGEN_CONSUMPTION_FACTOR).multiply(userWeightKg)
                .divide(MET_DIVISOR, 4, RoundingMode.HALF_UP);

        if (calPerMinute.compareTo(BigDecimal.ZERO) <= 0) return 0;

        return totalKcal.divide(calPerMinute, 0, RoundingMode.CEILING).intValue();
    }
}
