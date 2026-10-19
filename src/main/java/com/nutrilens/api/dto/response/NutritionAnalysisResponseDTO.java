package com.nutrilens.api.dto.response;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NutritionAnalysisResponseDTO {
    private String foodName;
    private BigDecimal effectiveVolumeCm3;
    private BigDecimal estimatedWeightGrams;
    private BigDecimal totalCaloriesKcal;
    private BigDecimal proteinGrams;
    private BigDecimal carbGrams;
    private BigDecimal fatGrams;
    private Integer runningMinutesNeeded;
    private Integer briskWalkingMinutesNeeded;

    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }
    public BigDecimal getEffectiveVolumeCm3() { return effectiveVolumeCm3; }
    public void setEffectiveVolumeCm3(BigDecimal effectiveVolumeCm3) { this.effectiveVolumeCm3 = effectiveVolumeCm3; }
    public BigDecimal getEstimatedWeightGrams() { return estimatedWeightGrams; }
    public void setEstimatedWeightGrams(BigDecimal estimatedWeightGrams) { this.estimatedWeightGrams = estimatedWeightGrams; }
    public BigDecimal getTotalCaloriesKcal() { return totalCaloriesKcal; }
    public void setTotalCaloriesKcal(BigDecimal totalCaloriesKcal) { this.totalCaloriesKcal = totalCaloriesKcal; }
    public BigDecimal getProteinGrams() { return proteinGrams; }
    public void setProteinGrams(BigDecimal proteinGrams) { this.proteinGrams = proteinGrams; }
    public BigDecimal getCarbGrams() { return carbGrams; }
    public void setCarbGrams(BigDecimal carbGrams) { this.carbGrams = carbGrams; }
    public BigDecimal getFatGrams() { return fatGrams; }
    public void setFatGrams(BigDecimal fatGrams) { this.fatGrams = fatGrams; }
    public Integer getRunningMinutesNeeded() { return runningMinutesNeeded; }
    public void setRunningMinutesNeeded(Integer runningMinutesNeeded) { this.runningMinutesNeeded = runningMinutesNeeded; }
    public Integer getBriskWalkingMinutesNeeded() { return briskWalkingMinutesNeeded; }
    public void setBriskWalkingMinutesNeeded(Integer briskWalkingMinutesNeeded) { this.briskWalkingMinutesNeeded = briskWalkingMinutesNeeded; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String foodName;
        private BigDecimal effectiveVolumeCm3;
        private BigDecimal estimatedWeightGrams;
        private BigDecimal totalCaloriesKcal;
        private BigDecimal proteinGrams;
        private BigDecimal carbGrams;
        private BigDecimal fatGrams;
        private Integer runningMinutesNeeded;
        private Integer briskWalkingMinutesNeeded;

        public Builder foodName(String foodName) { this.foodName = foodName; return this; }
        public Builder effectiveVolumeCm3(BigDecimal effectiveVolumeCm3) { this.effectiveVolumeCm3 = effectiveVolumeCm3; return this; }
        public Builder estimatedWeightGrams(BigDecimal estimatedWeightGrams) { this.estimatedWeightGrams = estimatedWeightGrams; return this; }
        public Builder totalCaloriesKcal(BigDecimal totalCaloriesKcal) { this.totalCaloriesKcal = totalCaloriesKcal; return this; }
        public Builder proteinGrams(BigDecimal proteinGrams) { this.proteinGrams = proteinGrams; return this; }
        public Builder carbGrams(BigDecimal carbGrams) { this.carbGrams = carbGrams; return this; }
        public Builder fatGrams(BigDecimal fatGrams) { this.fatGrams = fatGrams; return this; }
        public Builder runningMinutesNeeded(Integer runningMinutesNeeded) { this.runningMinutesNeeded = runningMinutesNeeded; return this; }
        public Builder briskWalkingMinutesNeeded(Integer briskWalkingMinutesNeeded) { this.briskWalkingMinutesNeeded = briskWalkingMinutesNeeded; return this; }

        public NutritionAnalysisResponseDTO build() {
            NutritionAnalysisResponseDTO dto = new NutritionAnalysisResponseDTO();
            dto.foodName = this.foodName;
            dto.effectiveVolumeCm3 = this.effectiveVolumeCm3;
            dto.estimatedWeightGrams = this.estimatedWeightGrams;
            dto.totalCaloriesKcal = this.totalCaloriesKcal;
            dto.proteinGrams = this.proteinGrams;
            dto.carbGrams = this.carbGrams;
            dto.fatGrams = this.fatGrams;
            dto.runningMinutesNeeded = this.runningMinutesNeeded;
            dto.briskWalkingMinutesNeeded = this.briskWalkingMinutesNeeded;
            return dto;
        }
    }
}
