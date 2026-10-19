package com.nutrilens.api.dto.response;

import java.math.BigDecimal;

public class MealItemResponseDTO {
    private Long id;
    private Long foodDensityId;
    private String foodCode;
    private String foodName;
    private String category;
    private String emoji;
    private String iconType;
    private String iconBgColor;
    private String iconColor;
    private BigDecimal rawVolumeCm3;
    private BigDecimal portionRatio;
    private BigDecimal effectiveVolumeCm3;
    private BigDecimal estimatedWeightG;
    private BigDecimal calculatedKcal;
    private BigDecimal proteinG;
    private BigDecimal carbG;
    private BigDecimal fatG;
    private BigDecimal confidenceScore;

    public MealItemResponseDTO() {}

    // Explicit Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getFoodDensityId() { return foodDensityId; }
    public void setFoodDensityId(Long foodDensityId) { this.foodDensityId = foodDensityId; }
    public String getFoodCode() { return foodCode; }
    public void setFoodCode(String foodCode) { this.foodCode = foodCode; }
    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getEmoji() { return emoji; }
    public void setEmoji(String emoji) { this.emoji = emoji; }
    public String getIconType() { return iconType; }
    public void setIconType(String iconType) { this.iconType = iconType; }
    public String getIconBgColor() { return iconBgColor; }
    public void setIconBgColor(String iconBgColor) { this.iconBgColor = iconBgColor; }
    public String getIconColor() { return iconColor; }
    public void setIconColor(String iconColor) { this.iconColor = iconColor; }
    public BigDecimal getRawVolumeCm3() { return rawVolumeCm3; }
    public void setRawVolumeCm3(BigDecimal rawVolumeCm3) { this.rawVolumeCm3 = rawVolumeCm3; }
    public BigDecimal getPortionRatio() { return portionRatio; }
    public void setPortionRatio(BigDecimal portionRatio) { this.portionRatio = portionRatio; }
    public BigDecimal getEffectiveVolumeCm3() { return effectiveVolumeCm3; }
    public void setEffectiveVolumeCm3(BigDecimal effectiveVolumeCm3) { this.effectiveVolumeCm3 = effectiveVolumeCm3; }
    public BigDecimal getEstimatedWeightG() { return estimatedWeightG; }
    public void setEstimatedWeightG(BigDecimal estimatedWeightG) { this.estimatedWeightG = estimatedWeightG; }
    public BigDecimal getCalculatedKcal() { return calculatedKcal; }
    public void setCalculatedKcal(BigDecimal calculatedKcal) { this.calculatedKcal = calculatedKcal; }
    public BigDecimal getProteinG() { return proteinG; }
    public void setProteinG(BigDecimal proteinG) { this.proteinG = proteinG; }
    public BigDecimal getCarbG() { return carbG; }
    public void setCarbG(BigDecimal carbG) { this.carbG = carbG; }
    public BigDecimal getFatG() { return fatG; }
    public void setFatG(BigDecimal fatG) { this.fatG = fatG; }
    public BigDecimal getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(BigDecimal confidenceScore) { this.confidenceScore = confidenceScore; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private Long foodDensityId;
        private String foodCode;
        private String foodName;
        private String category;
        private String emoji;
        private String iconType;
        private String iconBgColor;
        private String iconColor;
        private BigDecimal rawVolumeCm3;
        private BigDecimal portionRatio;
        private BigDecimal effectiveVolumeCm3;
        private BigDecimal estimatedWeightG;
        private BigDecimal calculatedKcal;
        private BigDecimal proteinG;
        private BigDecimal carbG;
        private BigDecimal fatG;
        private BigDecimal confidenceScore;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder foodDensityId(Long foodDensityId) { this.foodDensityId = foodDensityId; return this; }
        public Builder foodCode(String foodCode) { this.foodCode = foodCode; return this; }
        public Builder foodName(String foodName) { this.foodName = foodName; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder emoji(String emoji) { this.emoji = emoji; return this; }
        public Builder iconType(String iconType) { this.iconType = iconType; return this; }
        public Builder iconBgColor(String iconBgColor) { this.iconBgColor = iconBgColor; return this; }
        public Builder iconColor(String iconColor) { this.iconColor = iconColor; return this; }
        public Builder rawVolumeCm3(BigDecimal rawVolumeCm3) { this.rawVolumeCm3 = rawVolumeCm3; return this; }
        public Builder portionRatio(BigDecimal portionRatio) { this.portionRatio = portionRatio; return this; }
        public Builder effectiveVolumeCm3(BigDecimal effectiveVolumeCm3) { this.effectiveVolumeCm3 = effectiveVolumeCm3; return this; }
        public Builder estimatedWeightG(BigDecimal estimatedWeightG) { this.estimatedWeightG = estimatedWeightG; return this; }
        public Builder calculatedKcal(BigDecimal calculatedKcal) { this.calculatedKcal = calculatedKcal; return this; }
        public Builder proteinG(BigDecimal proteinG) { this.proteinG = proteinG; return this; }
        public Builder carbG(BigDecimal carbG) { this.carbG = carbG; return this; }
        public Builder fatG(BigDecimal fatG) { this.fatG = fatG; return this; }
        public Builder confidenceScore(BigDecimal confidenceScore) { this.confidenceScore = confidenceScore; return this; }

        public MealItemResponseDTO build() {
            MealItemResponseDTO dto = new MealItemResponseDTO();
            dto.id = this.id;
            dto.foodDensityId = this.foodDensityId;
            dto.foodCode = this.foodCode;
            dto.foodName = this.foodName;
            dto.category = this.category;
            dto.emoji = this.emoji;
            dto.iconType = this.iconType;
            dto.iconBgColor = this.iconBgColor;
            dto.iconColor = this.iconColor;
            dto.rawVolumeCm3 = this.rawVolumeCm3;
            dto.portionRatio = this.portionRatio;
            dto.effectiveVolumeCm3 = this.effectiveVolumeCm3;
            dto.estimatedWeightG = this.estimatedWeightG;
            dto.calculatedKcal = this.calculatedKcal;
            dto.proteinG = this.proteinG;
            dto.carbG = this.carbG;
            dto.fatG = this.fatG;
            dto.confidenceScore = this.confidenceScore;
            return dto;
        }
    }
}
