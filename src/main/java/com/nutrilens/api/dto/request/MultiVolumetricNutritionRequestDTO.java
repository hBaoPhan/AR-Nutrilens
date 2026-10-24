package com.nutrilens.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultiVolumetricNutritionRequestDTO {

    @NotEmpty(message = "Scanned components list cannot be empty")
    @Valid
    private List<VolumetricComponentItemDTO> components;

    @NotNull(message = "User body weight is required for MET burn estimation")
    @DecimalMin(value = "30.0", message = "User weight must be at least 30.0 kg")
    @DecimalMax(value = "250.0", message = "User weight exceeds maximum allowable limit")
    private BigDecimal userWeightKg;

    public List<VolumetricComponentItemDTO> getComponents() { return components; }
    public void setComponents(List<VolumetricComponentItemDTO> components) { this.components = components; }
    public BigDecimal getUserWeightKg() { return userWeightKg; }
    public void setUserWeightKg(BigDecimal userWeightKg) { this.userWeightKg = userWeightKg; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private List<VolumetricComponentItemDTO> components;
        private BigDecimal userWeightKg;

        public Builder components(List<VolumetricComponentItemDTO> components) { this.components = components; return this; }
        public Builder userWeightKg(BigDecimal userWeightKg) { this.userWeightKg = userWeightKg; return this; }

        public MultiVolumetricNutritionRequestDTO build() {
            MultiVolumetricNutritionRequestDTO dto = new MultiVolumetricNutritionRequestDTO();
            dto.components = this.components;
            dto.userWeightKg = this.userWeightKg;
            return dto;
        }
    }
}
