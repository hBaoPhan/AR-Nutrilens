package com.nutrilens.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentNutritionResultDTO {

    private String foodCode;
    private String displayName;
    private String foodType; // COMPOSITE_DISH or ATOMIC_INGREDIENT
    private String emoji;
    private BigDecimal effectiveVolumeCm3;
    private BigDecimal estimatedWeightGrams;
    private BigDecimal caloriesKcal;
    private BigDecimal proteinGrams;
    private BigDecimal carbGrams;
    private BigDecimal fatGrams;

    public String getFoodCode() { return foodCode; }
    public void setFoodCode(String foodCode) { this.foodCode = foodCode; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public String getFoodType() { return foodType; }
    public void setFoodType(String foodType) { this.foodType = foodType; }
    public String getEmoji() { return emoji; }
    public void setEmoji(String emoji) { this.emoji = emoji; }
    public BigDecimal getEffectiveVolumeCm3() { return effectiveVolumeCm3; }
    public void setEffectiveVolumeCm3(BigDecimal effectiveVolumeCm3) { this.effectiveVolumeCm3 = effectiveVolumeCm3; }
    public BigDecimal getEstimatedWeightGrams() { return estimatedWeightGrams; }
    public void setEstimatedWeightGrams(BigDecimal estimatedWeightGrams) { this.estimatedWeightGrams = estimatedWeightGrams; }
    public BigDecimal getCaloriesKcal() { return caloriesKcal; }
    public void setCaloriesKcal(BigDecimal caloriesKcal) { this.caloriesKcal = caloriesKcal; }
    public BigDecimal getProteinGrams() { return proteinGrams; }
    public void setProteinGrams(BigDecimal proteinGrams) { this.proteinGrams = proteinGrams; }
    public BigDecimal getCarbGrams() { return carbGrams; }
    public void setCarbGrams(BigDecimal carbGrams) { this.carbGrams = carbGrams; }
    public BigDecimal getFatGrams() { return fatGrams; }
    public void setFatGrams(BigDecimal fatGrams) { this.fatGrams = fatGrams; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String foodCode;
        private String displayName;
        private String foodType;
        private String emoji;
        private BigDecimal effectiveVolumeCm3;
        private BigDecimal estimatedWeightGrams;
        private BigDecimal caloriesKcal;
        private BigDecimal proteinGrams;
        private BigDecimal carbGrams;
        private BigDecimal fatGrams;

        public Builder foodCode(String foodCode) { this.foodCode = foodCode; return this; }
        public Builder displayName(String displayName) { this.displayName = displayName; return this; }
        public Builder foodType(String foodType) { this.foodType = foodType; return this; }
        public Builder emoji(String emoji) { this.emoji = emoji; return this; }
        public Builder effectiveVolumeCm3(BigDecimal effectiveVolumeCm3) { this.effectiveVolumeCm3 = effectiveVolumeCm3; return this; }
        public Builder estimatedWeightGrams(BigDecimal estimatedWeightGrams) { this.estimatedWeightGrams = estimatedWeightGrams; return this; }
        public Builder caloriesKcal(BigDecimal caloriesKcal) { this.caloriesKcal = caloriesKcal; return this; }
        public Builder proteinGrams(BigDecimal proteinGrams) { this.proteinGrams = proteinGrams; return this; }
        public Builder carbGrams(BigDecimal carbGrams) { this.carbGrams = carbGrams; return this; }
        public Builder fatGrams(BigDecimal fatGrams) { this.fatGrams = fatGrams; return this; }

        public ComponentNutritionResultDTO build() {
            ComponentNutritionResultDTO dto = new ComponentNutritionResultDTO();
            dto.foodCode = this.foodCode;
            dto.displayName = this.displayName;
            dto.foodType = this.foodType;
            dto.emoji = this.emoji;
            dto.effectiveVolumeCm3 = this.effectiveVolumeCm3;
            dto.estimatedWeightGrams = this.estimatedWeightGrams;
            dto.caloriesKcal = this.caloriesKcal;
            dto.proteinGrams = this.proteinGrams;
            dto.carbGrams = this.carbGrams;
            dto.fatGrams = this.fatGrams;
            return dto;
        }
    }
}
