package com.nutrilens.api.dto.response;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDTO {
    private String token;
    private String tokenType;
    private Long userId;
    private String username;
    private String email;
    private String fullName;
    private String role;
    private BigDecimal weightKg;
    private BigDecimal heightCm;
    private Integer dailyCalorieGoal;
    private String gender;
    private Integer age;
    private String activityLevel;
    private String fitnessGoal;

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
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

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String token;
        private String tokenType = "Bearer";
        private Long userId;
        private String username;
        private String email;
        private String fullName;
        private String role;
        private BigDecimal weightKg;
        private BigDecimal heightCm;
        private Integer dailyCalorieGoal = 2000;
        private String gender = "MALE";
        private Integer age = 25;
        private String activityLevel = "SEDENTARY";
        private String fitnessGoal = "MAINTAIN";

        public Builder token(String token) { this.token = token; return this; }
        public Builder tokenType(String tokenType) { this.tokenType = tokenType; return this; }
        public Builder userId(Long userId) { this.userId = userId; return this; }
        public Builder username(String username) { this.username = username; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder fullName(String fullName) { this.fullName = fullName; return this; }
        public Builder role(String role) { this.role = role; return this; }
        public Builder weightKg(BigDecimal weightKg) { this.weightKg = weightKg; return this; }
        public Builder heightCm(BigDecimal heightCm) { this.heightCm = heightCm; return this; }
        public Builder dailyCalorieGoal(Integer dailyCalorieGoal) { this.dailyCalorieGoal = dailyCalorieGoal; return this; }
        public Builder gender(String gender) { this.gender = gender; return this; }
        public Builder age(Integer age) { this.age = age; return this; }
        public Builder activityLevel(String activityLevel) { this.activityLevel = activityLevel; return this; }
        public Builder fitnessGoal(String fitnessGoal) { this.fitnessGoal = fitnessGoal; return this; }

        public AuthResponseDTO build() {
            AuthResponseDTO dto = new AuthResponseDTO();
            dto.token = this.token;
            dto.tokenType = this.tokenType;
            dto.userId = this.userId;
            dto.username = this.username;
            dto.email = this.email;
            dto.fullName = this.fullName;
            dto.role = this.role;
            dto.weightKg = this.weightKg;
            dto.heightCm = this.heightCm;
            dto.dailyCalorieGoal = this.dailyCalorieGoal;
            dto.gender = this.gender;
            dto.age = this.age;
            dto.activityLevel = this.activityLevel;
            dto.fitnessGoal = this.fitnessGoal;
            return dto;
        }
    }
}
