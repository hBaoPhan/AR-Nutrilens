package com.nutrilens.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meal_logs", indexes = {
    @Index(name = "idx_meal_user_logged", columnList = "user_id, logged_at")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "meal_type", nullable = false, length = 20)
    private String mealType;

    @Column(name = "logged_at", nullable = false)
    private LocalDateTime loggedAt;

    @Column(name = "total_volume_cm3", nullable = false, precision = 8, scale = 2)
    private BigDecimal totalVolumeCm3 = BigDecimal.ZERO;

    @Column(name = "total_weight_g", nullable = false, precision = 8, scale = 2)
    private BigDecimal totalWeightG = BigDecimal.ZERO;

    @Column(name = "total_kcal", nullable = false, precision = 8, scale = 2)
    private BigDecimal totalKcal = BigDecimal.ZERO;

    @Column(name = "total_protein_g", nullable = false, precision = 6, scale = 2)
    private BigDecimal totalProteinG = BigDecimal.ZERO;

    @Column(name = "total_carb_g", nullable = false, precision = 6, scale = 2)
    private BigDecimal totalCarbG = BigDecimal.ZERO;

    @Column(name = "total_fat_g", nullable = false, precision = 6, scale = 2)
    private BigDecimal totalFatG = BigDecimal.ZERO;

    @Column(name = "ar_snapshot_url", length = 500)
    private String arSnapshotUrl;

    @Column(name = "user_notes", length = 2000)
    private String userNotes;

    @OneToMany(mappedBy = "mealLog", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("mealLog")
    @Builder.Default
    private List<MealItem> items = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Explicit Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
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
    public List<MealItem> getItems() { return items; }
    public void setItems(List<MealItem> items) { this.items = items; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
