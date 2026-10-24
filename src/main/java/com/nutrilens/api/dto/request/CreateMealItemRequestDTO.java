package com.nutrilens.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreateMealItemRequestDTO {

    @NotBlank(message = "Food code is required")
    private String foodCode;

    private String foodName;

    private BigDecimal portionRatio;

    private BigDecimal rawVolumeCm3;

    private BigDecimal effectiveVolumeCm3;

    private BigDecimal estimatedWeightG;

    @NotNull(message = "Calculated kcal is required")
    private BigDecimal calculatedKcal;

    private BigDecimal proteinG;

    private BigDecimal carbG;

    private BigDecimal fatG;

    private BigDecimal confidenceScore;

    public CreateMealItemRequestDTO() {}

    public String getFoodCode() { return foodCode; }
    public void setFoodCode(String foodCode) { this.foodCode = foodCode; }

    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }

    public BigDecimal getPortionRatio() { return portionRatio; }
    public void setPortionRatio(BigDecimal portionRatio) { this.portionRatio = portionRatio; }

    public BigDecimal getRawVolumeCm3() { return rawVolumeCm3; }
    public void setRawVolumeCm3(BigDecimal rawVolumeCm3) { this.rawVolumeCm3 = rawVolumeCm3; }

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
}
