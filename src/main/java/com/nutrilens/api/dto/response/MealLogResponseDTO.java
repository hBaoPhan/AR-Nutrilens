package com.nutrilens.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MealLogResponseDTO {
    private Long id;
    private Long userId;
    private String username;
    private String userFullName;
    private String mealType;
    private LocalDateTime loggedAt;
    private String loggedAtDisplay;
    private BigDecimal totalVolumeCm3;
    private BigDecimal totalWeightG;
    private BigDecimal totalKcal;
    private BigDecimal totalProteinG;
    private BigDecimal totalCarbG;
    private BigDecimal totalFatG;
    private String arSnapshotUrl;
    private String userNotes;
    private int runningMinutesNeeded;
    private int walkingMinutesNeeded;
    private List<MealItemResponseDTO> items = new ArrayList<>();

    public MealLogResponseDTO() {}

    // Explicit Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getUserFullName() { return userFullName; }
    public void setUserFullName(String userFullName) { this.userFullName = userFullName; }
    public String getMealType() { return mealType; }
    public void setMealType(String mealType) { this.mealType = mealType; }
    public LocalDateTime getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
    public String getLoggedAtDisplay() { return loggedAtDisplay; }
    public void setLoggedAtDisplay(String loggedAtDisplay) { this.loggedAtDisplay = loggedAtDisplay; }
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
    public int getRunningMinutesNeeded() { return runningMinutesNeeded; }
    public void setRunningMinutesNeeded(int runningMinutesNeeded) { this.runningMinutesNeeded = runningMinutesNeeded; }
    public int getWalkingMinutesNeeded() { return walkingMinutesNeeded; }
    public void setWalkingMinutesNeeded(int walkingMinutesNeeded) { this.walkingMinutesNeeded = walkingMinutesNeeded; }
    public List<MealItemResponseDTO> getItems() { return items; }
    public void setItems(List<MealItemResponseDTO> items) { this.items = items; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private Long userId;
        private String username;
        private String userFullName;
        private String mealType;
        private LocalDateTime loggedAt;
        private String loggedAtDisplay;
        private BigDecimal totalVolumeCm3;
        private BigDecimal totalWeightG;
        private BigDecimal totalKcal;
        private BigDecimal totalProteinG;
        private BigDecimal totalCarbG;
        private BigDecimal totalFatG;
        private String arSnapshotUrl;
        private String userNotes;
        private int runningMinutesNeeded;
        private int walkingMinutesNeeded;
        private List<MealItemResponseDTO> items = new ArrayList<>();

        public Builder id(Long id) { this.id = id; return this; }
        public Builder userId(Long userId) { this.userId = userId; return this; }
        public Builder username(String username) { this.username = username; return this; }
        public Builder userFullName(String userFullName) { this.userFullName = userFullName; return this; }
        public Builder mealType(String mealType) { this.mealType = mealType; return this; }
        public Builder loggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; return this; }
        public Builder loggedAtDisplay(String loggedAtDisplay) { this.loggedAtDisplay = loggedAtDisplay; return this; }
        public Builder totalVolumeCm3(BigDecimal totalVolumeCm3) { this.totalVolumeCm3 = totalVolumeCm3; return this; }
        public Builder totalWeightG(BigDecimal totalWeightG) { this.totalWeightG = totalWeightG; return this; }
        public Builder totalKcal(BigDecimal totalKcal) { this.totalKcal = totalKcal; return this; }
        public Builder totalProteinG(BigDecimal totalProteinG) { this.totalProteinG = totalProteinG; return this; }
        public Builder totalCarbG(BigDecimal totalCarbG) { this.totalCarbG = totalCarbG; return this; }
        public Builder totalFatG(BigDecimal totalFatG) { this.totalFatG = totalFatG; return this; }
        public Builder arSnapshotUrl(String arSnapshotUrl) { this.arSnapshotUrl = arSnapshotUrl; return this; }
        public Builder userNotes(String userNotes) { this.userNotes = userNotes; return this; }
        public Builder runningMinutesNeeded(int runningMinutesNeeded) { this.runningMinutesNeeded = runningMinutesNeeded; return this; }
        public Builder walkingMinutesNeeded(int walkingMinutesNeeded) { this.walkingMinutesNeeded = walkingMinutesNeeded; return this; }
        public Builder items(List<MealItemResponseDTO> items) { this.items = items; return this; }

        public MealLogResponseDTO build() {
            MealLogResponseDTO dto = new MealLogResponseDTO();
            dto.id = this.id;
            dto.userId = this.userId;
            dto.username = this.username;
            dto.userFullName = this.userFullName;
            dto.mealType = this.mealType;
            dto.loggedAt = this.loggedAt;
            dto.loggedAtDisplay = this.loggedAtDisplay;
            dto.totalVolumeCm3 = this.totalVolumeCm3;
            dto.totalWeightG = this.totalWeightG;
            dto.totalKcal = this.totalKcal;
            dto.totalProteinG = this.totalProteinG;
            dto.totalCarbG = this.totalCarbG;
            dto.totalFatG = this.totalFatG;
            dto.arSnapshotUrl = this.arSnapshotUrl;
            dto.userNotes = this.userNotes;
            dto.runningMinutesNeeded = this.runningMinutesNeeded;
            dto.walkingMinutesNeeded = this.walkingMinutesNeeded;
            dto.items = this.items != null ? this.items : new ArrayList<>();
            return dto;
        }
    }
}
