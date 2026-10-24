package com.nutrilens.api.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileRequestDTO {

    @NotNull(message = "Cân nặng không được để trống")
    @DecimalMin(value = "30.00", message = "Cân nặng tối thiểu là 30kg")
    @DecimalMax(value = "300.00", message = "Cân nặng tối đa là 300kg")
    private BigDecimal weightKg;

    @NotNull(message = "Chiều cao không được để trống")
    @DecimalMin(value = "80.00", message = "Chiều cao tối thiểu là 80cm")
    @DecimalMax(value = "250.00", message = "Chiều cao tối đa là 250cm")
    private BigDecimal heightCm;

    @NotNull(message = "Mục tiêu calo không được để trống")
    @Min(value = 800, message = "Mục tiêu calo tối thiểu là 800 kcal")
    @Max(value = 6000, message = "Mục tiêu calo tối đa là 6000 kcal")
    private Integer dailyCalorieGoal;

    @Pattern(regexp = "^(MALE|FEMALE|OTHER)$", message = "Giới tính phải là MALE, FEMALE hoặc OTHER")
    private String gender;

    @Min(value = 10, message = "Tuổi tối thiểu là 10")
    @Max(value = 120, message = "Tuổi tối đa là 120")
    private Integer age;

    @Size(max = 30)
    private String activityLevel;

    @Size(max = 30)
    private String fitnessGoal;

    public BigDecimal getWeightKg() { return weightKg; }
    public void setWeightKg(BigDecimal weightKg) { this.weightKg = weightKg; }
    public BigDecimal getHeightCm() { return heightCm; }
    public void setHeightCm(BigDecimal heightCm) { this.heightCm = heightCm; }
    public Integer getDailyCalorieGoal() { return dailyCalorieGoal; }
    public void setDailyCalorieGoal(Integer dailyCalorieGoal) { this.dailyCalorieGoal = dailyCalorieGoal; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getActivityLevel() { return activityLevel; }
    public void setActivityLevel(String activityLevel) { this.activityLevel = activityLevel; }
    public String getFitnessGoal() { return fitnessGoal; }
    public void setFitnessGoal(String fitnessGoal) { this.fitnessGoal = fitnessGoal; }
}
