package com.nutrilens.api.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VolumetricNutritionRequestDTO {

    @NotBlank(message = "Food identifier code is required")
    private String foodCode;

    @NotNull(message = "Scanned volume in cm3 is required")
    @DecimalMin(value = "0.50", message = "Volume must be at least 0.50 cm3")
    @DecimalMax(value = "4000.00", message = "Volume exceeds plate physical limit")
    private BigDecimal volumeCm3;

    @NotNull(message = "Portion ratio is required")
    @DecimalMin(value = "0.05", message = "Portion ratio cannot be under 5%")
    @DecimalMax(value = "1.00", message = "Portion ratio cannot exceed 100%")
    private BigDecimal portionRatio = BigDecimal.ONE;

    @NotNull(message = "User body weight is required for MET calculation")
    @DecimalMin(value = "30.0", message = "User weight must be at least 30.0 kg")
    @DecimalMax(value = "250.0", message = "User weight exceeds maximum allowable limit")
    private BigDecimal userWeightKg;

    // Explicit accessors & Builder to guarantee robust execution across all JDK compilers
    public String getFoodCode() { return foodCode; }
    public void setFoodCode(String foodCode) { this.foodCode = foodCode; }
    public BigDecimal getVolumeCm3() { return volumeCm3; }
    public void setVolumeCm3(BigDecimal volumeCm3) { this.volumeCm3 = volumeCm3; }
    public BigDecimal getPortionRatio() { return portionRatio; }
    public void setPortionRatio(BigDecimal portionRatio) { this.portionRatio = portionRatio; }
    public BigDecimal getUserWeightKg() { return userWeightKg; }
    public void setUserWeightKg(BigDecimal userWeightKg) { this.userWeightKg = userWeightKg; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String foodCode;
        private BigDecimal volumeCm3;
        private BigDecimal portionRatio = BigDecimal.ONE;
        private BigDecimal userWeightKg;

        public Builder foodCode(String foodCode) { this.foodCode = foodCode; return this; }
        public Builder volumeCm3(BigDecimal volumeCm3) { this.volumeCm3 = volumeCm3; return this; }
        public Builder portionRatio(BigDecimal portionRatio) { this.portionRatio = portionRatio; return this; }
        public Builder userWeightKg(BigDecimal userWeightKg) { this.userWeightKg = userWeightKg; return this; }

        public VolumetricNutritionRequestDTO build() {
            VolumetricNutritionRequestDTO dto = new VolumetricNutritionRequestDTO();
            dto.foodCode = this.foodCode;
            dto.volumeCm3 = this.volumeCm3;
            dto.portionRatio = this.portionRatio;
            dto.userWeightKg = this.userWeightKg;
            return dto;
        }
    }
}
