package com.nutrilens.api.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VolumetricComponentItemDTO {

    @NotBlank(message = "Component food identifier code is required")
    private String foodCode;

    @NotNull(message = "Component volume in cm3 is required")
    @DecimalMin(value = "0.50", message = "Component volume must be at least 0.50 cm3")
    @DecimalMax(value = "4000.00", message = "Component volume exceeds allowable physical limit")
    private BigDecimal volumeCm3;

    @NotNull(message = "Component portion ratio is required")
    @DecimalMin(value = "0.05", message = "Portion ratio cannot be under 5%")
    @DecimalMax(value = "1.00", message = "Portion ratio cannot exceed 100%")
    private BigDecimal portionRatio = BigDecimal.ONE;

    public String getFoodCode() { return foodCode; }
    public void setFoodCode(String foodCode) { this.foodCode = foodCode; }
    public BigDecimal getVolumeCm3() { return volumeCm3; }
    public void setVolumeCm3(BigDecimal volumeCm3) { this.volumeCm3 = volumeCm3; }
    public BigDecimal getPortionRatio() { return portionRatio; }
    public void setPortionRatio(BigDecimal portionRatio) { this.portionRatio = portionRatio; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String foodCode;
        private BigDecimal volumeCm3;
        private BigDecimal portionRatio = BigDecimal.ONE;

        public Builder foodCode(String foodCode) { this.foodCode = foodCode; return this; }
        public Builder volumeCm3(BigDecimal volumeCm3) { this.volumeCm3 = volumeCm3; return this; }
        public Builder portionRatio(BigDecimal portionRatio) { this.portionRatio = portionRatio; return this; }

        public VolumetricComponentItemDTO build() {
            VolumetricComponentItemDTO dto = new VolumetricComponentItemDTO();
            dto.foodCode = this.foodCode;
            dto.volumeCm3 = this.volumeCm3;
            dto.portionRatio = this.portionRatio;
            return dto;
        }
    }
}
