package com.nutrilens.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CreateMealLogRequestDTO {

    private Long userId;

    private String username;

    @NotBlank(message = "Meal type is required (Breakfast, Lunch, Dinner)")
    private String mealType;

    private LocalDateTime loggedAt;

    private BigDecimal totalVolumeCm3;

    private BigDecimal totalWeightG;

    @NotNull(message = "Total kcal is required")
    private BigDecimal totalKcal;

    private BigDecimal totalProteinG;

    private BigDecimal totalCarbG;

    private BigDecimal totalFatG;

    private String arSnapshotUrl;

    private String userNotes;

    @NotEmpty(message = "At least one meal item must be included")
    @Valid
    private List<CreateMealItemRequestDTO> items;

    public CreateMealLogRequestDTO() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getMealType() { return mealType; }
    public void setMealType(String mealType) { this.mealType = mealType; }

    public LocalDateTime getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }

    public BigDecimal getTotalVolumeCm3() { return totalVolumeCm3; }
    public void setTotalVolumeCm3(BigDecimal totalVolumeCm3) { this.totalVolumeCm3 = totalVolumeCm3; }

    public BigDecimal getTotalWeightG() { return totalWeightG; }
    public void setTotalWeightG(BigDecimal totalWeightG) { this.totalWeightG = totalWeightG; }

    public BigDecimal getTotalKcal() { return totalKcal; }
    public void setTotalKcal(BigDecimal totalKcal) { this.totalKcal = totalKcal; }

    public BigDecimal getTotalProteinG() { return totalProteinG; }
    public void setTotalProteinG(BigDecimal totalProteinG) { this.totalProteinG = totalProteinG; }

    public BigDecimal getTotalCarbG() { return totalCarbG; }
    public void setTotalCarbG(BigDecimal totalCarbG) { this.totalCarbG = totalCarbG; }

    public BigDecimal getTotalFatG() { return totalFatG; }
    public void setTotalFatG(BigDecimal totalFatG) { this.totalFatG = totalFatG; }

    public String getArSnapshotUrl() { return arSnapshotUrl; }
    public void setArSnapshotUrl(String arSnapshotUrl) { this.arSnapshotUrl = arSnapshotUrl; }

    public String getUserNotes() { return userNotes; }
    public void setUserNotes(String userNotes) { this.userNotes = userNotes; }

    public List<CreateMealItemRequestDTO> getItems() { return items; }
    public void setItems(List<CreateMealItemRequestDTO> items) { this.items = items; }
}
