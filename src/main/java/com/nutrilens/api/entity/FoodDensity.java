package com.nutrilens.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_densities", indexes = {
    @Index(name = "idx_food_code", columnList = "food_code", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDensity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "food_code", nullable = false, unique = true, length = 50)
    private String foodCode;

    @Column(name = "display_name", nullable = false, length = 150)
    private String displayName;

    @Column(name = "category", length = 50)
    private String category = "Breakfast";

    @Column(name = "density_g_per_cm3", nullable = false, precision = 6, scale = 4)
    private BigDecimal densityGramsPerCm3;

    @Column(name = "kcal_per_100g", nullable = false, precision = 6, scale = 2)
    private BigDecimal kcalPer100g;

    @Column(name = "protein_per_100g", nullable = false, precision = 6, scale = 2)
    private BigDecimal proteinPer100g;

    @Column(name = "carb_per_100g", nullable = false, precision = 6, scale = 2)
    private BigDecimal carbPer100g;

    @Column(name = "fat_per_100g", nullable = false, precision = 6, scale = 2)
    private BigDecimal fatPer100g;

    @Column(name = "serving_weight_g", precision = 6, scale = 2)
    private BigDecimal servingWeightG = new BigDecimal("100.00");

    @Column(name = "serving_volume_cm3", precision = 6, scale = 2)
    private BigDecimal servingVolumeCm3 = new BigDecimal("150.00");

    @Column(name = "emoji", length = 20)
    private String emoji;

    @Column(name = "icon_type", length = 50)
    private String iconType = "salad";

    @Column(name = "icon_bg_color", length = 20)
    private String iconBgColor = "#FFEFE6";

    @Column(name = "icon_color", length = 20)
    private String iconColor = "#F37340";

    @Column(name = "is_highlighted_more")
    private Boolean isHighlightedMore = false;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Explicit Getters and Setters for full compatibility
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFoodCode() { return foodCode; }
    public void setFoodCode(String foodCode) { this.foodCode = foodCode; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public BigDecimal getDensityGramsPerCm3() { return densityGramsPerCm3; }
    public void setDensityGramsPerCm3(BigDecimal densityGramsPerCm3) { this.densityGramsPerCm3 = densityGramsPerCm3; }
    public BigDecimal getKcalPer100g() { return kcalPer100g; }
    public void setKcalPer100g(BigDecimal kcalPer100g) { this.kcalPer100g = kcalPer100g; }
    public BigDecimal getProteinPer100g() { return proteinPer100g; }
    public void setProteinPer100g(BigDecimal proteinPer100g) { this.proteinPer100g = proteinPer100g; }
    public BigDecimal getCarbPer100g() { return carbPer100g; }
    public void setCarbPer100g(BigDecimal carbPer100g) { this.carbPer100g = carbPer100g; }
    public BigDecimal getFatPer100g() { return fatPer100g; }
    public void setFatPer100g(BigDecimal fatPer100g) { this.fatPer100g = fatPer100g; }
    public BigDecimal getServingWeightG() { return servingWeightG; }
    public void setServingWeightG(BigDecimal servingWeightG) { this.servingWeightG = servingWeightG; }
    public BigDecimal getServingVolumeCm3() { return servingVolumeCm3; }
    public void setServingVolumeCm3(BigDecimal servingVolumeCm3) { this.servingVolumeCm3 = servingVolumeCm3; }
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
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String foodCode;
        private String displayName;
        private String category = "Breakfast";
        private BigDecimal densityGramsPerCm3;
        private BigDecimal kcalPer100g;
        private BigDecimal proteinPer100g;
        private BigDecimal carbPer100g;
        private BigDecimal fatPer100g;
        private BigDecimal servingWeightG = new BigDecimal("100.00");
        private BigDecimal servingVolumeCm3 = new BigDecimal("150.00");
        private String emoji;
        private String iconType = "salad";
        private String iconBgColor = "#FFEFE6";
        private String iconColor = "#F37340";
        private Boolean isHighlightedMore = false;
        private Boolean isActive = true;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder foodCode(String foodCode) { this.foodCode = foodCode; return this; }
        public Builder displayName(String displayName) { this.displayName = displayName; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder densityGramsPerCm3(BigDecimal densityGramsPerCm3) { this.densityGramsPerCm3 = densityGramsPerCm3; return this; }
        public Builder kcalPer100g(BigDecimal kcalPer100g) { this.kcalPer100g = kcalPer100g; return this; }
        public Builder proteinPer100g(BigDecimal proteinPer100g) { this.proteinPer100g = proteinPer100g; return this; }
        public Builder carbPer100g(BigDecimal carbPer100g) { this.carbPer100g = carbPer100g; return this; }
        public Builder fatPer100g(BigDecimal fatPer100g) { this.fatPer100g = fatPer100g; return this; }
        public Builder servingWeightG(BigDecimal servingWeightG) { this.servingWeightG = servingWeightG; return this; }
        public Builder servingVolumeCm3(BigDecimal servingVolumeCm3) { this.servingVolumeCm3 = servingVolumeCm3; return this; }
        public Builder emoji(String emoji) { this.emoji = emoji; return this; }
        public Builder iconType(String iconType) { this.iconType = iconType; return this; }
        public Builder iconBgColor(String iconBgColor) { this.iconBgColor = iconBgColor; return this; }
        public Builder iconColor(String iconColor) { this.iconColor = iconColor; return this; }
        public Builder isHighlightedMore(Boolean isHighlightedMore) { this.isHighlightedMore = isHighlightedMore; return this; }
        public Builder isActive(Boolean isActive) { this.isActive = isActive; return this; }

        public FoodDensity build() {
            FoodDensity entity = new FoodDensity();
            entity.id = this.id;
            entity.foodCode = this.foodCode;
            entity.displayName = this.displayName;
            entity.category = this.category;
            entity.densityGramsPerCm3 = this.densityGramsPerCm3;
            entity.kcalPer100g = this.kcalPer100g;
            entity.proteinPer100g = this.proteinPer100g;
            entity.carbPer100g = this.carbPer100g;
            entity.fatPer100g = this.fatPer100g;
            entity.servingWeightG = this.servingWeightG;
            entity.servingVolumeCm3 = this.servingVolumeCm3;
            entity.emoji = this.emoji;
            entity.iconType = this.iconType;
            entity.iconBgColor = this.iconBgColor;
            entity.iconColor = this.iconColor;
            entity.isHighlightedMore = this.isHighlightedMore;
            entity.isActive = this.isActive;
            return entity;
        }
    }
}
