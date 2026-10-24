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
public class FoodItemResponseDTO {

    private Long id;
    private String foodCode;
    private String name;
    private String category;
    private String foodType; // COMPOSITE_DISH or ATOMIC_INGREDIENT
    private BigDecimal kcal;
    private BigDecimal weightG;
    private BigDecimal volumeCm3;
    private BigDecimal proteinG;
    private BigDecimal carbsG;
    private BigDecimal fatG;
    private String emoji;
    private String iconType;
    private String iconBgColor;
    private String iconColor;
    private Boolean isHighlightedMore;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFoodCode() { return foodCode; }
    public void setFoodCode(String foodCode) { this.foodCode = foodCode; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getFoodType() { return foodType; }
    public void setFoodType(String foodType) { this.foodType = foodType; }
    public BigDecimal getKcal() { return kcal; }
    public void setKcal(BigDecimal kcal) { this.kcal = kcal; }
    public BigDecimal getWeightG() { return weightG; }
    public void setWeightG(BigDecimal weightG) { this.weightG = weightG; }
    public BigDecimal getVolumeCm3() { return volumeCm3; }
    public void setVolumeCm3(BigDecimal volumeCm3) { this.volumeCm3 = volumeCm3; }
    public BigDecimal getProteinG() { return proteinG; }
    public void setProteinG(BigDecimal proteinG) { this.proteinG = proteinG; }
    public BigDecimal getCarbsG() { return carbsG; }
    public void setCarbsG(BigDecimal carbsG) { this.carbsG = carbsG; }
    public BigDecimal getFatG() { return fatG; }
    public void setFatG(BigDecimal fatG) { this.fatG = fatG; }
    public String getEmoji() { return emoji; }
    public void setEmoji(String emoji) { this.emoji = emoji; }
    public String getIconType() { return iconType; }
    public void setIconType(String iconType) { this.iconType = iconType; }
    public String getIconBgColor() { return iconBgColor; }
    public void setIconBgColor(String iconBgColor) { this.iconBgColor = iconBgColor; }
    public String getIconColor() { return iconColor; }
    public void setIconColor(String iconColor) { this.iconColor = iconColor; }
    public Boolean getIsHighlightedMore() { return isHighlightedMore; }
    public void setIsHighlightedMore(Boolean isHighlightedMore) { this.isHighlightedMore = isHighlightedMore; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String foodCode;
        private String name;
        private String category;
        private String foodType;
        private BigDecimal kcal;
        private BigDecimal weightG;
        private BigDecimal volumeCm3;
        private BigDecimal proteinG;
        private BigDecimal carbsG;
        private BigDecimal fatG;
        private String emoji;
        private String iconType;
        private String iconBgColor;
        private String iconColor;
        private Boolean isHighlightedMore;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder foodCode(String foodCode) { this.foodCode = foodCode; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder foodType(String foodType) { this.foodType = foodType; return this; }
        public Builder kcal(BigDecimal kcal) { this.kcal = kcal; return this; }
        public Builder weightG(BigDecimal weightG) { this.weightG = weightG; return this; }
        public Builder volumeCm3(BigDecimal volumeCm3) { this.volumeCm3 = volumeCm3; return this; }
        public Builder proteinG(BigDecimal proteinG) { this.proteinG = proteinG; return this; }
        public Builder carbsG(BigDecimal carbsG) { this.carbsG = carbsG; return this; }
        public Builder fatG(BigDecimal fatG) { this.fatG = fatG; return this; }
        public Builder emoji(String emoji) { this.emoji = emoji; return this; }
        public Builder iconType(String iconType) { this.iconType = iconType; return this; }
        public Builder iconBgColor(String iconBgColor) { this.iconBgColor = iconBgColor; return this; }
        public Builder iconColor(String iconColor) { this.iconColor = iconColor; return this; }
        public Builder isHighlightedMore(Boolean isHighlightedMore) { this.isHighlightedMore = isHighlightedMore; return this; }

        public FoodItemResponseDTO build() {
            FoodItemResponseDTO dto = new FoodItemResponseDTO();
            dto.id = this.id;
            dto.foodCode = this.foodCode;
            dto.name = this.name;
            dto.category = this.category;
            dto.foodType = this.foodType;
            dto.kcal = this.kcal;
            dto.weightG = this.weightG;
            dto.volumeCm3 = this.volumeCm3;
            dto.proteinG = this.proteinG;
            dto.carbsG = this.carbsG;
            dto.fatG = this.fatG;
            dto.emoji = this.emoji;
            dto.iconType = this.iconType;
            dto.iconBgColor = this.iconBgColor;
            dto.iconColor = this.iconColor;
            dto.isHighlightedMore = this.isHighlightedMore;
            return dto;
        }
    }
}
