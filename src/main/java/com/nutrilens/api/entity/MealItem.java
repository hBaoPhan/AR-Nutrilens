package com.nutrilens.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "meal_items", indexes = {
    @Index(name = "idx_item_meal_log", columnList = "meal_log_id")
})
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_log_id", nullable = false)
    @JsonIgnoreProperties("items")
    private MealLog mealLog;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_density_id", nullable = false)
    private FoodDensity foodDensity;

    @Column(name = "raw_volume_cm3", nullable = false, precision = 8, scale = 2)
    private BigDecimal rawVolumeCm3;

    @Column(name = "portion_ratio", nullable = false, precision = 4, scale = 3)
    private BigDecimal portionRatio = BigDecimal.ONE;

    @Column(name = "effective_volume_cm3", nullable = false, precision = 8, scale = 2)
    private BigDecimal effectiveVolumeCm3;

    @Column(name = "estimated_weight_g", nullable = false, precision = 8, scale = 2)
    private BigDecimal estimatedWeightG;

    @Column(name = "calculated_kcal", nullable = false, precision = 8, scale = 2)
    private BigDecimal calculatedKcal;

    @Column(name = "protein_g", nullable = false, precision = 6, scale = 2)
    private BigDecimal proteinG;

    @Column(name = "carb_g", nullable = false, precision = 6, scale = 2)
    private BigDecimal carbG;

    @Column(name = "fat_g", nullable = false, precision = 6, scale = 2)
    private BigDecimal fatG;

    @Column(name = "confidence_score", precision = 4, scale = 3)
    private BigDecimal confidenceScore = new BigDecimal("0.950");

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public MealItem() {}

    // Explicit Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public MealLog getMealLog() { return mealLog; }
    public void setMealLog(MealLog mealLog) { this.mealLog = mealLog; }
    public FoodDensity getFoodDensity() { return foodDensity; }
    public void setFoodDensity(FoodDensity foodDensity) { this.foodDensity = foodDensity; }
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
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private MealLog mealLog;
        private FoodDensity foodDensity;
        private BigDecimal rawVolumeCm3;
        private BigDecimal portionRatio = BigDecimal.ONE;
        private BigDecimal effectiveVolumeCm3;
        private BigDecimal estimatedWeightG;
        private BigDecimal calculatedKcal;
        private BigDecimal proteinG;
        private BigDecimal carbG;
        private BigDecimal fatG;
        private BigDecimal confidenceScore = new BigDecimal("0.950");

        public Builder id(Long id) { this.id = id; return this; }
        public Builder mealLog(MealLog mealLog) { this.mealLog = mealLog; return this; }
        public Builder foodDensity(FoodDensity foodDensity) { this.foodDensity = foodDensity; return this; }
        public Builder rawVolumeCm3(BigDecimal rawVolumeCm3) { this.rawVolumeCm3 = rawVolumeCm3; return this; }
        public Builder portionRatio(BigDecimal portionRatio) { this.portionRatio = portionRatio; return this; }
        public Builder effectiveVolumeCm3(BigDecimal effectiveVolumeCm3) { this.effectiveVolumeCm3 = effectiveVolumeCm3; return this; }
        public Builder estimatedWeightG(BigDecimal estimatedWeightG) { this.estimatedWeightG = estimatedWeightG; return this; }
        public Builder calculatedKcal(BigDecimal calculatedKcal) { this.calculatedKcal = calculatedKcal; return this; }
        public Builder proteinG(BigDecimal proteinG) { this.proteinG = proteinG; return this; }
        public Builder carbG(BigDecimal carbG) { this.carbG = carbG; return this; }
        public Builder fatG(BigDecimal fatG) { this.fatG = fatG; return this; }
        public Builder confidenceScore(BigDecimal confidenceScore) { this.confidenceScore = confidenceScore; return this; }

        public MealItem build() {
            MealItem item = new MealItem();
            item.id = this.id;
            item.mealLog = this.mealLog;
            item.foodDensity = this.foodDensity;
            item.rawVolumeCm3 = this.rawVolumeCm3;
            item.portionRatio = this.portionRatio;
            item.effectiveVolumeCm3 = this.effectiveVolumeCm3;
            item.estimatedWeightG = this.estimatedWeightG;
            item.calculatedKcal = this.calculatedKcal;
            item.proteinG = this.proteinG;
            item.carbG = this.carbG;
            item.fatG = this.fatG;
            item.confidenceScore = this.confidenceScore;
            return item;
        }
    }
}
