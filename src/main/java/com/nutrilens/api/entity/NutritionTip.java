package com.nutrilens.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "nutrition_tips", indexes = {
    @Index(name = "idx_tips_active", columnList = "is_active"),
    @Index(name = "idx_tips_target", columnList = "target_goal")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NutritionTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @Column(name = "icon_type", nullable = false, length = 50)
    private String iconType;

    @Column(name = "target_goal", nullable = false, length = 50)
    private String targetGoal;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String title;
        private String content;
        private String category;
        private String iconType = "salad";
        private String targetGoal = "ALL";
        private Boolean isActive = true;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder content(String content) { this.content = content; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder iconType(String iconType) { this.iconType = iconType; return this; }
        public Builder targetGoal(String targetGoal) { this.targetGoal = targetGoal; return this; }
        public Builder isActive(Boolean isActive) { this.isActive = isActive; return this; }
        public Builder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }
        public Builder updatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; return this; }

        public NutritionTip build() {
            NutritionTip tip = new NutritionTip();
            tip.setId(this.id);
            tip.setTitle(this.title);
            tip.setContent(this.content);
            tip.setCategory(this.category);
            tip.setIconType(this.iconType);
            tip.setTargetGoal(this.targetGoal);
            tip.setIsActive(this.isActive != null ? this.isActive : true);
            tip.setCreatedAt(this.createdAt);
            tip.setUpdatedAt(this.updatedAt);
            return tip;
        }
    }
}
