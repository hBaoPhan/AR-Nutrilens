package com.nutrilens.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionTipResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String category;
    private String iconType;
    private String targetGoal;
    private Boolean isActive;
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getIconType() { return iconType; }
    public void setIconType(String iconType) { this.iconType = iconType; }
    public String getTargetGoal() { return targetGoal; }
    public void setTargetGoal(String targetGoal) { this.targetGoal = targetGoal; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String title;
        private String content;
        private String category;
        private String iconType;
        private String targetGoal;
        private Boolean isActive;
        private LocalDateTime createdAt;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder content(String content) { this.content = content; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder iconType(String iconType) { this.iconType = iconType; return this; }
        public Builder targetGoal(String targetGoal) { this.targetGoal = targetGoal; return this; }
        public Builder isActive(Boolean isActive) { this.isActive = isActive; return this; }
        public Builder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }

        public NutritionTipResponseDTO build() {
            NutritionTipResponseDTO dto = new NutritionTipResponseDTO();
            dto.setId(this.id);
            dto.setTitle(this.title);
            dto.setContent(this.content);
            dto.setCategory(this.category);
            dto.setIconType(this.iconType);
            dto.setTargetGoal(this.targetGoal);
            dto.setIsActive(this.isActive);
            dto.setCreatedAt(this.createdAt);
            return dto;
        }
    }
}
