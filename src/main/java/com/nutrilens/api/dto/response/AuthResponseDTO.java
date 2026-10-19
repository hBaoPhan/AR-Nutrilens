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
    private String fullName;
    private String role;
    private BigDecimal weightKg;

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public BigDecimal getWeightKg() { return weightKg; }
    public void setWeightKg(BigDecimal weightKg) { this.weightKg = weightKg; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String token;
        private String tokenType = "Bearer";
        private Long userId;
        private String username;
        private String fullName;
        private String role;
        private BigDecimal weightKg;

        public Builder token(String token) { this.token = token; return this; }
        public Builder tokenType(String tokenType) { this.tokenType = tokenType; return this; }
        public Builder userId(Long userId) { this.userId = userId; return this; }
        public Builder username(String username) { this.username = username; return this; }
        public Builder fullName(String fullName) { this.fullName = fullName; return this; }
        public Builder role(String role) { this.role = role; return this; }
        public Builder weightKg(BigDecimal weightKg) { this.weightKg = weightKg; return this; }

        public AuthResponseDTO build() {
            AuthResponseDTO dto = new AuthResponseDTO();
            dto.token = this.token;
            dto.tokenType = this.tokenType;
            dto.userId = this.userId;
            dto.username = this.username;
            dto.fullName = this.fullName;
            dto.role = this.role;
            dto.weightKg = this.weightKg;
            return dto;
        }
    }
}
